# Main function used to handle all the variables and function calls
def main():
    # Score is amount of correct, max is total amount, then we have
    # variables for the different weights.
    homework_score = [39, 40, 29, 40, 0, 5]
    homework_max = [40, 40, 40, 40, 40, 5]
    homework = 0.20

    quiz_score = [10, 10, 9, 2, 10, 10, 10]
    quiz_max = [10, 10, 10, 10, 10, 10, 10]
    quiz = 0.20

    test_score = [293, 284, 300]
    test_max = [300, 300, 300]
    test = 0.60

# the find variables take the average of each component
    find_homework_grade = average(homework_score, homework_max)
    find_quiz_grade = average(quiz_score, quiz_max)
    find_test_grade = average(test_score, test_max)

# These variables convert the grade to a float
    hwk_avg = str(int(find_homework_grade * 100))
    quiz_avg = str(int(find_quiz_grade * 100))
    test_avg = str(int(find_test_grade * 100))

# The weighted variables calculate the grades with the weights
    hw_weighted = average_weighted(homework_score, homework_max, homework)
    quiz_weighted = average_weighted(quiz_score, quiz_max, quiz)
    test_weighted = average_weighted(test_score, test_max, test)

# Final grade adds the three weighted grades together
    final_grade = (hw_weighted + quiz_weighted + test_weighted)

# The following lines print the grade and letter using multiple
# called functions and variables.
    hwk_letter = 'C'
    print("Homework grade: " + str(int(hwk_avg)) + ' ' + str(hwk_letter))

    quiz_letter = 'B'
    print("Quiz grade: " + str(int(quiz_avg)) + ' ' + str(quiz_letter))

    test_letter = 'A'
    print("Test grade: " + str(int(test_avg)) + ' ' + str(test_letter))

    final_letter = letter_grade(final_grade)
    print("Final Score: " + str(int(final_grade * 100))\
    + ' ' + str(final_letter))

# Finds the average of 2 given lists


def average(score_list, max_list):
    average = sum(score_list) / sum(max_list)
    return average


# Calculates the letter grade given a float

def letter_grade(percent):
    if percent >= .9:
        return "A"
    elif percent >= .8:
        return "B"
    elif percent >= .7:
        return "C"
    elif percent >= .6:
        return "D"
    elif percent < .6:
        return "F"


# Calculates weighted average of 2 lists and a weight variable

def average_weighted(score_list, max_list, weight):
    average_weight = average(score_list, max_list)
    return average_weight * weight


# Setting the main function
if __name__ == '__main__':
    main()
