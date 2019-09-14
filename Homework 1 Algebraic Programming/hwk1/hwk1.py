# This is a comment.  It is a sequence of text that is ignored by the Python
# interpreter.  Programmers use comments to leave one another messages in code
# files.  In this case, instead of messages telling you why I've chosen to write
# code in a certain way or messages explaining tricky parts of the code, my
# comments will tell you what functions to create in this file.  I've given you
# the first function below as a model of the function definition syntax.

# Once you have a definition for each of these functions, you're not done yet!
# Please open a Python interpreter in the folder where this file is stored and
# import all your functions by typing 'from hwk1 import *'.  Next, call your
# functions with some test values to make sure you get a reasonable result.

# Remember to delete my instruction comments before you print your file to save
# yourself some paper/ink (you can always re-download this file from BBLearn if
# you want to look at them again).  Additionally, if you think of any good
# questions while solving these problems, put them down as comments of your own
# so you remember to ask them in class.


# Function 0: Pounds to kilos
# I'm giving you this one for free so that you can remember what a properly
# defined function looks like
def pounds_to_kilos(pounds):
    return 0.453592 * pounds


# Function 1: Kilos to pounds
# 'pass' is a Python keyword that serves as a placeholder for code that hasn't
# been written yet.  I've put it here so that I could provide you with the first
# line of the function definition (the function signature) to get you started.
def kilos_to_pounds(kilos):
    pass


# Function 2: Fahrenheit to celcius
def fahrenheit_to_celcius(f):
    pass


# Function 3: Celcius to Fahrenheit
# For this one, you have to write the whole thing!.  You should call the
# function 'celcius_to_faherenheit'.



# Function 4: Hours, minutes, and seconds to seconds
# This function has three parameters: hours, minutes, and seconds.  It should
# calculate how many seconds there are total in the given number of hours,
# minutes, and seconds and return that result
def hms_to_seconds(hours, minutes, seconds):
    pass


# Function 5: Distance between two points
# This function has four parameters since each point has an 'x' and a 'y'
# component.  In order to find the distance between these two points, you will
# need to do a square root.  Python has a built-in square root function called
# sqrt(), but it is part of the math library so it can't be accessed without
# importing it first.  To do this, put the line 'from math import sqrt' up at
# the very top of this file (without the quotes of course).
def distance_between_points(x1, y1, x2, y2):
    pass


# Function 6: Shortest distance between three points
# This function takes in a whopping six parameters in order to represent three
# points!  We're looking for the distance between the two points that are
# closest together out of the three.  While the previous functions can all be
# written on one line, this one will be easiest if you assign some variable
# names to the intermediate results (like the distances between the pairs of
# points).  At the end, you'll want to return the smallest of the distances
# you've found; how do you do that?  Open up a python interpreter and type
# 'help(min)' paying special attention to the last line.
def sdbtp(x1, y1, x2, y2, x3, y3):
    pass
