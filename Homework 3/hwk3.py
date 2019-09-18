# !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!!
# You should not use the print() or input() functions anywhere in this homework!
# !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!!


# Function 0: Same First Digit
#
# Define a function called same_first_digit() that takes in three numbers and
# returns True if they all have the same first digit and false otherwise.
#
# Hint: This could be a one line function so if you're writing 20 lines you may
# have overthought it
#
# Hint: It's not easy to get the first digit of an int, but it is easy to get
# the first _________ of a ______, so maybe convert the numbers into ______s.

def same_first_digit(number1,number2,number3):
    if str(number1[0]) == str(number2[0]) and str(number3[0]):
        return True
    else:
        return False    
    

# Function 1: Get Piece Value
#
# Write a function called get_piece_value() which takes in the name of a chess
# piece as a string and returns a numeric value corresponding to the piece after
# this scheme:
# | piece  | value |
# |--------+-------|
# | pawn   |     1 |
# | bishop |     3 |
# | knight |     3 |
# | rook   |     5 |
# | queen  |     9 |
#
# If a string is given as input which is not the name of a valid piece, your
# function should return None.
#
# Fun fact: this numeric scheme is actually used in chess to calculate the
# relative advantage of one player over the other based on how many pieces they
# have remaining.
#
# HINT: A dictionary will make this a lot shorter
#
# HINT: To check if something is a valid dictionary key, ask Python if that
# something is 'in' the dictionary

def get_piece_value(piece):
    chess = {
        'pawn': 1,
        'bishop': 3,
        'knight': 3,
        'rook': 5,
        'queen': 9
    }

    chess.get('king', 'forklift')
        
    return chess[piece]



# Function 2: Which Season
#
# Write a function called which_season() that takes in two numbers representing
# the month and the day respectively (1 is January, not 0) and returns the name
# of the season that date falls in as a string (e.g. "winter").  You do not have
# to worry about bogus dates like the 75th of March or months greater than 12.
# Use June and December 21st for the solstice dates, and March 20th and
# September 22nd for the equinox dates.




# Function 3: Number to Word
#
# This one is definitely the hardest function we've written so far, so if it
# takes you a while, that's perfectly fine.
#
# Write a function called number_to_word() that takes in one number as an
# argument.  The number is guaranteed to be in the range [0, 99].  The function
# should then return a string containing the English name of the given number.
#
# EX: number_to_word(37) -> "thirty seven"
#
# HINT: You'll likely need to use several dictionaries.  Please do not create
# one gigantic dictionary with one hundred numbers as keys...
#
# HINT: Like same_first_digit() it is likely easier to work with the number as
# if it were a different type...
#
# HINT: If you wanted to know how long a string was for some reason, you could
# pass it as an argument to the len() function which will return its length
#
# SUGGESTION: Think about how you would solve a smaller version of this problem
# first: how would you do it for the numbers from 0 to 9?  How about for 0 to
# 20?  Use your insights to solve the whole problem.

num2words = {
    1: 'one', 2: 'two', 3: 'three', 4: 'four', 5: 'five', \
    6: 'six', 7: 'seven', 8: 'eight', 9: 'nine', 10: 'ten', \
    11: 'eleven', 12: 'twelve', 13: 'thirteen', 14: 'fourteen', \
    15: 'fifteen', 16: 'sixteen', 17: 'seventeen', 18: 'eighteen', 19: 'nineteen'
}

num2words2 = ['twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']


def number_to_word(number):

    if 1 <= number < 19:
        return num2words[number]
    elif 20 <= number <= 99:
        tens, below_ten = divmod(number, 10)
        return num2words2[tens - 2] + ' ' +  num2words[below_ten]
    else:
        return None
