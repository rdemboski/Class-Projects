# Ryan Demboski, Beizhe Shen
# CS-126L Section 001
# Lab 9 Draw Stars
# 11/18/2019


# Required module imports
import turtle
import sys


# Uses sys to utilize an input file via an argument in the command line.
txt_file_open = open(sys.argv[1], 'r')

# Create the drawing space
turtle_object = turtle.Turtle()

# Set drawing space boundaries
turtle.setworldcoordinates(-250, -250, 250, 250)


def read_coords():
    # Reads the lines of the txt file then closes it
    star_data = txt_file_open.readlines()
    txt_file_open.close()
    # Dictionaries to store coords and magnitude
    coordinates = {}
    magnitudes = {}
    for line in star_data:
        # Splits along the spaces in the data
        line = line.split(' ')
        # Makes a tuple of x and y coordinates
        coordinates[line[3]] = (float(line[0]), float(line[1]))
        # Makes a tuple of magnitude position
        magnitudes[line[3]] = float(line[4])
    return (coordinates, magnitudes)


def magnitude(coords_dict, mag_dict):
    # These are for setting up the turtle
    turtle.bgcolor('black')
    turtle.hideturtle()
    turtle.speed(100)
    turtle.delay(0)
    turtle.tracer(0, 0)
    turtle.update()
    turtle.screensize(500, 500)

    for mag in mag_dict:
        # Equation that makes the magnitude scale correctly
        star_size = min(round((10 / ((mag_dict[mag]) + 2))), 8)
        # Picks up the pen
        turtle.penup()
        # Sets the x and y coordinates
        turtle.setx(coords_dict[mag][0] * 250)
        turtle.sety(coords_dict[mag][1] * 250)
        # Turtle drawing command, draws a dot for each star based on
        # the magnitude of the star for size.
        turtle.dot(star_size, "white")


# Calling the read_coords function to run
# the magnitude function and getting the x and y coordinates.
read_star_data = read_coords()
magnitude(read_star_data[0], read_star_data[1])

# Exit whenever the user clicks.
turtle.exitonclick()
