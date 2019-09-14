# !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!!
# You should NOT use the print() or input() functions anywhere in this homework!
# !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!!


# Function 0: Seconds into days, hours, minutes, and seconds

# Write a function called seconds_to_dhms() which takes in a number representing
# a number of seconds and returns the number of days, hours, minutes, and
# seconds equivalent to the given number of seconds.  To simulate returning more
# than one value from a function, use a line like this: return (thing1, thing2,
# thing3)

# Hints:
#   You don't need any conditionals for this problem
#   Modulo and integer division are your friends

def seconds_to_dhms(input):
    day = input // (24 * 3600)
    input = input % (24 * 3600)
    hours = input // 3600

    input %= 3600
    minutes = n // 60

    input %= 60
    seconds = input
    
    return (day,hours,minutes,seconds)

# Function 1: Metricifier

# Write a function called metricifier() that takes in two numbers.  The first
# number represents a quantity and the second number is a flag which causes the
# function to do different conversions after this scheme:

# | flag | first input | output    |
# |------+-------------+-----------|
# |    0 | Fahrenheit  | celcius   |
# |    1 | feet        | meters    |
# |    2 | pounds      | kilograms |
# |    3 | gallons     | liters    |

def metricifier(quantity, flag):
    if quantity == 0:
        return flag
    
    


# Function 2: Valid triangle detector

# Write a function called is_valid_triangle() that takes in three positive
# integers and then determines whether those integers could be the lengths of
# the sides of a triangle.  This can be done by checking that the length of any
# side is not greater than the sum of the other two; if it is, then a triangle
# cannot be formed from sides of those lengths.  This function should return a
# boolean value.

def is_valid_triangle(side1,side2,side3):
    if side1 > side2 + side3:
        return False
    elif side2 > side1 + side3:
        return False
    elif side3 > side1 + side2:
        return False
    else:
        return True

# Function 3: Rock, Paper, Scissors

# Write a function called find_rps_outcome() which takes in two strings (when
# the function is called, the strings will be one of "rock", "paper", or
# "scissors").  If the first string wins it should return the string "Player 1
# wins" and, if the second string wins, "Player 2 wins".  If there is a tie, it
# should return the string "Tie game".

# Hints:
#   Strings can be compared for equality just like numbers can
#   Think about all the possible paths to each outcome before writing any code


# This function is turned in from a seperate file...
