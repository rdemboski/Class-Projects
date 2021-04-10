# Ryan Demboski
# Hunter Woodruff
# CS126 Lab Section 001
# 10/27/2019

def main():
    # opens input file as read closes when complete
    # opens output file as write closes when complete
    with open('lab08_input_file.txt', 'r') as input_grades:
        with open('grade_calculations.html', 'w') as grcalc:
            # defines all variables to be used
            hw = []
            quizzes = []
            tests = []
            proj = []
            final = []
            line = 0
            catigory = []
            value = []
            values = []
            score = []
            max = []
            # loops through each line of the input file
            # and splits the lines on spaces
            # removes new line character
            # removes the % sign
            # and splites the string of corect over max
            # at the commas
            for line in input_grades:
                index = 0
                sccounter = 0
                maxcounter = 0
                catigory = line.strip("\n")
                catigory = catigory.replace('%', '')
                catigory = catigory.split(' ', 2)
                scores = catigory[2].split(',')
                # takes in the scored points over max
                # splits them on the divide sign
                while index < len(scores):
                    values.append(scores[index].split('/'))
                    index += 1
                # creates list of scores
                while sccounter < len(values):
                    score.append(values[sccounter][0])
                    sccounter += 1
                # creats list of max achievable    
                while maxcounter < len(values):
                    max.append(values[maxcounter][1])
                    maxcounter += 1
                # function calls
                avg = average(score, max)
                letter = letter_grade(avg)
                weight = average_weighted(score, max, catigory[1])
                # Writes to output file
                # in html format
                grcalcs.write(f'<h1>{catigory[0]} Statistics (10.0)</h1>\n')
                grcalc.write(f'<ul>\n')
                grcalc.write(f'<li><b>Average: </b>{avg}</li>\n')
                grcalc.write(f'<li><b>Letter Grade: </b>{letter}</li>\n')
                grcalc.write(f'<li><b>Overall Grade Contribution')
                grcalc.write(f': </b>{weight}</li>\n')
                grcalc.write(f'</ul>\n')


# averages scores over max
def average(score_list, max_list):
    scnum = 0
    mnum = 0
    while scnum < len(score_list):
        score_list[scnum] = int(score_list[scnum])
        scnum += 1
    while mnum < len(max_list):
        max_list[mnum] = int(max_list[mnum])
        mnum += 1
    sum_score_list = sum(score_list)
    sum_max_list = sum(max_list)
    return float(sum_score_list/sum_max_list)


# takes in the average and returns the letter grade
def letter_grade(percent):
    if percent >= .9:
        return str('A')
    elif percent >= .8:
        return str('B')
    elif percent >= .7:
        return str('C')
    elif percent >= .6:
        return str('D')
    else:
        return str('F')

# averages the scores of scores over max
# multiplies by the weight value of the given catigory
def average_weighted(score_list, max_list, weight):
    total_score = sum(score_list)
    total_max = sum(max_list)
    return float(total_score/total_max) * int(weight)

# calls main
if __name__ == '__main__':
    main()
