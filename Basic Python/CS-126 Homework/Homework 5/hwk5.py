# !!! Solutions that sidestep using loops will not be awarded full credit !!!

# Function 0: Count Vowels
# Write a function called count_vowels() that takes in a string and returns the
# number of vowels in the string.  It counts 'y' as a vowel.  The input string
# may be in upper, lower, or mixed case.
#
# Hint: You may want to write an is_vowel() helper function

def count_vowels(string):
    vowels = ['A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'Y', 'y']
    num_vowels = 0
    for char in string:
        if char in vowels:
            num_vowels += 1
    return num_vowels

# Function 1: String to ASCII Codes
#
# Write a function called str_to_ascii() that takes in a string and returns a
# list of integers corresponding to the ASCII codes of the characters in the
# string.
#
# Hint: If you can't remember the name of the function that gets an ASCII code
# for a character, that's ok, I'm sure Google does.

def str_to_ascii(string):
    list = []
    for char in string:
        list.append(ord(char))
    return list

# Function 2: Remove Vowels
#
# Write a function called remove_vowels() that takes in a string and returns a
# new lowercase string with all the vowels removed.  It counts 'y' as a vowel.
# The input string may be in upper, lower, or mixed case.

def remove_vowels(string):
    result = ""
    for vowel in string.lower():
        if not (vowel in "aeiouy"):
            result += vowel
    return result

# Function 3: Remove Every Other Character
#
# Write a function called every_other_character() that takes in a string and
# returns a new string with every other character removed.  That is, the new
# string will include the first, third, fifth, etc. letters of the given
# string.

def every_other_character(string):
    result = ""
    for char in range(len(string)):
        if (char % 2 == 0):
            result += string[char]
    return result
    
# Function 4: Max
#
# Write a function called max() that takes in a list of numbers and returns the
# largest one

def max(list):
    if(list == None or len(list) == 0):
        return(None, None)
    else:
        max_value = list[0]
    for x in list:
        if(max_value < x):
            max_value = x
    return(max_value)

# Function 5: Palindrome Detection
#
# Write a function called is_palindrome() which takes in a single string
# parameter.  The function should return True if the string is a palindrome and
# False otherwise.  The case of the string should not affect correctly
# detecting a palindrome; neither should spaces, commas, or apostrophes.

def is_palindrome(string):
    modified_string = ''
    reversed_string = ''
    for char in string:
        char = char.lower()
        if char != ' ' and char != ',' and char != '\'':
            modified_string += char
            reversed_string = char + reversed_string
    return modified_string == reversed_string
