import sys
import importlib
import timeout_decorator
import traceback
from logging import basicConfig, info, warning, critical, error, INFO
from random import randint


def run(reference_module, student_module_name):
  try:
    student_module = importlib.import_module(student_module_name)
    test_suite = TestSuite.from_test_specs(reference_module.test_specs, reference_module, student_module)
    print(test_suite.run_all_tests())
  except ModuleNotFoundError:
    print(f"""{_bad('Could not find your homework file.')}
Have you checked that:
\t1. Your homework file is named correctly ({student_module_name}.py)
\t2. Your homework file is in the current directory""")
    return


def generate_random_letter_string(length):
  random_lower = lambda: chr(randint(97, 122))
  random_upper = lambda: chr(randint(65, 90))
  random_letter = lambda: random_upper() if randint(0, 1) else random_lower()
  return ''.join([random_letter() for i in range(length + 1)])


def _good(string):
  return '\x1b[32m' + string + '\x1b[39;49m'


def _bad(string):
  return '\x1b[31m' + string + '\x1b[39;49m'


class TestSuite:
  @staticmethod
  def from_test_specs(test_specs, reference_module, student_module):
    ts = TestSuite()
    for spec in test_specs:
      type = spec.get('type', 'function')
      if type == 'function':
        test_class = FunctionTest
      elif type == 'method':
        test_class = MethodTest
      else:
        raise "Unknown test type; Notify your instructor"

      ts.add_test(test_class.from_spec(spec, reference_module, student_module))
    return ts


  def __init__(self):
    self._tests = []


  def add_test(self, test):
    self._tests.append(test)


  def run_all_tests(self):
    report = []
    total_test_cases = 0
    passed_test_cases = 0
    for test in self._tests:
      total_test_cases += test.get_test_case_count()
      (test_report, passed_test_case_count) = test.run_all_test_cases()
      passed_test_cases += passed_test_case_count
      report.append(test_report)
    grade = passed_test_cases / total_test_cases * 100
    colorizer = _bad if grade < 70 else _good
    p_out_of_t = colorizer(f"{passed_test_cases} out of {total_test_cases}")
    report.append(f"You passed {p_out_of_t} total test cases\n")

    return '\n\n\n\n'.join(report)



class Test:
  def __init__(self):
    self._test_cases = []

  def get_test_case_count(self):
    return len(self._test_cases)

  def add_test_case_for_input(self, input):
    if not isinstance(input, tuple):
      input = (input,)
    self._test_cases.append({'input': input})



class DefectiveTest(Test):
  def __init__(self, message):
    super().__init__()
    self._report = message
    self._report += f"\n\n0 out of {self.get_test_case_count()} test cases"
    self._report = _bad(self._report)

  def get_passed_test_case_count(self):
    return 0

  def run_all_test_cases(self):
    return (self._report, 0)



class FunctionTest(Test):
  @staticmethod
  def from_spec(spec, reference_module, student_module):
    student_func = student_module.__dict__.get(spec['target_name'])
    reference_func = reference_module.__dict__.get(spec['target_name'])
    func_name = spec['target_name'] + '()'

    if student_func == None:
      report = f"No implementation of {func_name}; You should write one!"
      test = DefectiveTest(report)
    elif reference_func == None:
      report = f"No reference implementation of {func_name};\n" + \
        "You should tell your instructor about this"
      test = DefectiveTest(report)
    else:
      test = FunctionTest(student_func, reference_func,
                          tolerance=spec.get('tolerance'))
    for test_input in spec['inputs']:
      test.add_test_case_for_input(test_input)
    return test


  def __init__(self, student_function, reference_function, tolerance=None):
    super().__init__()
    self._student_function = timeout_decorator.timeout(1)(student_function)
    self._reference_function = reference_function
    self._tolerance = tolerance


  def get_test_case_count(self):
    return len(self._test_cases)


  def run_all_test_cases(self):
    func_name = self._student_function.__name__ + '()'
    test_report = [f"Tests for function {func_name}:"]
    passed_test_case_count = 0
    for test_case in self._test_cases:
      (test_case_report, outcome) = self._run_test_case(test_case)
      test_report += test_case_report
      passed_test_case_count += 1 if outcome else 0
    test_report.append(f"{func_name}: {passed_test_case_count} out of {self.get_test_case_count()} test cases")
    return ('\n'.join(test_report), passed_test_case_count)


  def _run_test_case(self, tc):
    tc['reference_output'] = self._reference_function(*tc['input'])
    try:
      tc['student_output'] = self._student_function(*tc['input'])
    except Exception as e:
      tc['student_error'] = traceback.format_exc()

    return self._format_test_case_report(tc)


  def _format_test_case_report(self, tc):
    outcome = self._determine_outcome(tc)
    passed_or_failed = _good('passed') if outcome else _bad('FAILED')
    report = [f"{passed_or_failed} with this input: {', '.join(map(repr, tc['input']))}"]
    if tc.get('student_error'):
      report.append("The following error occurred:")
      report += ['\t' + line for line in tc['student_error'].split('\n')]
      report[-1] += '\n'
      return (report, outcome)

    caser = str.lower if outcome else str.upper

    report += [f"\t{caser('EXPECTED')}: {self._format_expected_result(tc)}",
               f"\t{caser('YOURFUNC')}: {self._format_student_output(tc)}",
               "\n"]

    return (report, outcome)


  def _determine_outcome(self, tc):
    if tc.get('student_error'):
      return False
    elif not (type(tc['reference_output']) == type(tc['student_output'])):
      tc['student_error'] = "This function should return a value of " + \
        f"{type(tc['reference_output'])}\nbut instead it returned " + \
        f"a {type(tc['student_output'])}\n" +\
        f"\tEXPECTED: {repr(tc['reference_output'])}\n" + \
        f"\tYOURFUNC: {repr(tc['student_output'])}"
      return False
    elif self._tolerance:
      lower_limit = tc['reference_output'] - self._tolerance
      upper_limit = tc['reference_output'] + self._tolerance
      return lower_limit <= tc['student_output'] <= upper_limit
    else:
      return tc['reference_output'] == tc['student_output']


  def _format_expected_result(self, tc):
    if self._tolerance:
      rounded_answer = round(tc['reference_output'],
                             len(str(self._tolerance)) - 2)
      return f"{repr(rounded_answer)} ±{self._tolerance}"
    return repr(tc['reference_output'])


  def _format_student_output(self, tc):
    return repr(tc['student_output'])

