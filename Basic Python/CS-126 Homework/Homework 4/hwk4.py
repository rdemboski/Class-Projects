# Function 0: Numbers to Words
#
# This one is definitely the hardest function we've written so far, so if it
# takes you a while, that's perfectly fine.
#
# Write a function called number_to_word() that takes in one number as an
# argument.  The number is guaranteed to be in the range [0, 99].  The function
# should then return a string containing the English name of the given number.
#
# EX: number_to_word(37) → "thirty seven"
#
# HINT: You'll likely need to use several dictionaries.  Please do not create
# one gigantic dictionary with one hundred numbers as keys...
#
# HINT: If you wanted to know how long a string was for some reason, you could
# pass it as an argument to the len() function which will return its length

def number_to_word(number):

    num2words = {
        1: 'one', 2: 'two', 3: 'three', 4: 'four', 5: 'five', \
        6: 'six', 7: 'seven', 8: 'eight', 9: 'nine', 10: 'ten', \
        11: 'eleven', 12: 'twelve', 13: 'thirteen', 14: 'fourteen', \
        15: 'fifteen', 16: 'sixteen', 17: 'seventeen', 18: 'eighteen', 19: 'nineteen'
    }

    num2words2 = ['twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']

    if 1 <= number <= 19:
        return num2words[number]
    elif 20 <= number <= 99:
        tens, below_ten = divmod(number, 10)
        return num2words2[tens - 2] + ' ' + num2words[below_ten]
    else:
        return None

# Function 1: Palindrome Detection
#
# Write a function called is_palindrome() which takes in a single string
# parameter.  The function should return True if the string is a palindrome and
# False otherwise.  A palindrome is a string which can be read in the same way
# both forward and backward, "mom" for example.  The case of the string should
# not affect correctly detecting a palindrome; neither should spaces, commas, or
# apostrophes.
#
# HINT: You can reverse a string with string slicing by providing a 'step' of
# negative one, i.e. 'hello'[::-1]
#
# HINT: If you wanted to 'remove' a specific character from a string, you could
# use the str.replace() method in a clever way

import string

ignored = string.punctuation + " "

def is_palindrome(word):
    cleanstr = ""
    for i in word:
        cleanstr += "" if i in ignored else i

    if cleanstr.lower() == cleanstr[::-1].lower():
        return True
    else:
        return False
        
# Function 2: Formatting Dates
#
# Write a function called format_date() which takes in a single parameter which
# is a string of the format yyyymmdd (like 20190209) and returns a string of
# the format "February 9th, 2019"

from datetime import datetime

#def format_date(date):
 #   date_string = str(date)
  #  return datetime.date(date_string[0:4]), date_string[4:6]), date_string[6:8]))
    

# Function 3: Roman Numerals
#
# Write a function called romanize() that takes in one number as an argument.
# The number is guaranteed to be in the range [1, 99].  The function should
# return a string containing the Roman Numeral representation of the number.
#
# SUGGESTION: If you don't know/remember how Roman Numerals work, Google it
#
# SUGGESTION: Solve this for the numbers 1 to 10 then extend your solution

def romanize(number):

    num2roman = {
        1: 'I', 2: 'II', 3: 'III', 4: 'IV', 5: 'V', 6: 'VI', 7: 'VII', 8: 'VIII', 9: 'IX'
    }
    num2roman2 = {
        10: 'X', 20: 'XX', 30: 'XXX', 40: 'XL', 50: 'L', 60: 'LX', 70: 'LXX', 80: 'LXXX', 90: 'XC'
    }

    if len(number) > 1 and number[0] > 1:
        return num2roman2[number] + num2roman[number]
    elif len(number) <= 1:
        return num2roman[number]
    

# Function 4: Extra Credit! Standardize phone numbers
#
# Uncomment the lines below to enter into the mystery
# def standardize_phone_number(phone_number):
#     return False
