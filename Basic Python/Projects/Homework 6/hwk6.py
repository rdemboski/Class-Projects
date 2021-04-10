# Function 0: Calculating a Checksum
#
# A checksum is a way to verify that data transmission has occurred without
# data loss or corruption.  This works by taking the data that is about to be
# transmitted and creating some sort of summary value that is dependent on the
# data and then sending it along with the data.  Once the data is received, the
# summary value can be recalculated using the same method and compared to the
# summary value that came with the data: if they match, all is well; if not,
# something went wrong.
#
# Write a function called checksum() that takes in a string and generates a
# simple checksum: add up the numerical codes that correspond to the letters of
# the string and then return this sum

def checksum(string):
    result = 0
    for letter in string:
        result += ord(letter)
    return result

# Function 1: Finding Character Frequency
#
# Write a function called character_frequency() that takes in two strings, a word
# and a single character.  Your function should report what proportion of the
# given word the given character makes up.  The function should report the
# proportion as a percentage rounded to two decimal places

def character_frequency(word, char):
    count = 0
    for one in word:
        if one == char:
            count += 1
    return round((count/len(word))*100, 2)

# Function 2: Finding the First Factor
#
# Write a function called first_factor() which takes in a number and returns
# the first number greater than one which evenly divides that number

def first_factor(number):
    for num in range(2, number + 1):
        if number % num == 0:
            return num

# Function 3: Detecting Primes
#
# Write a function called is_prime() that takes in an integer and returns True if it is prime and False otherwise.
#
# Hint: remind yourself of what it means for a number to be prime by looking
# it up
#
# Hint: *DON'T* look up how to decide if a number is prime on the
# internet, you will almost certainly find a bunch of really complicated
# code that is overkill for this problem
#
# Hint: You have already implemented another function that you could call to
# make this problem easier (assuming you are doing these in order)

def is_prime(number):
    for num in range(2, number):
        if number % num == 0:
            return False
    return True

# Function 4: Matching Parentheses
#
# Define a function called all_parens_matched() that takes in a string and
# returns True if the string contains properly matched parenthesis pairs.
#
# Ex.  "(this (string) is) (fine)"
# Ex.  ")this (string) was (doomed from (the start))"
# Ex.  "(this (string looks (fine until the end)))("
#
# Hint: Order matters! You can't simply count the number of open parentheses
# and compare to the number of close parentheses
#
# Hint: Talk this one out (or write out the logic on paper) and then figure
# out how to do it with code. E.G. "Once I've seen an open paren, I need to
# see a closing one to be happy, but if I see more closing parens than open
# ones... etc.
#
# Hint: This problem is hard!

def all_parens_matched(string):
    start_paren = '('
    end_paren = ')'
    total_count1 = string.count(start_paren)
    total_count2 = string.count(end_paren)
    count1 = 0
    count2 = 0
    
    if total_count1 != total_count2:
        return False
    else:
        for char in string:
            if char == '(':
                count1 += 1
            elif char == ')':
                count2 += 1
            if count1 < count2:
                return False
        return True