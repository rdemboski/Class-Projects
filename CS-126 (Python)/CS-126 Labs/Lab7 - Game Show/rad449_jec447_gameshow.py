
# Ryan Demboski, Jordan Colebank
# 10/21/2019
# Lab 7 Game Show
# Section 001

import random

# Stored questions in a list, each has its own dictionary
questions = [
    {
        "prompt": "What is the largest bone in the human body?",
        "answers": [
            "Tibia",
            "Femur",
            "Skull",
            "Patella"
        ],
        "correct": "2"
    },
    {
        "prompt": "Whats the total number of dots on a pair of dice?",
        "answers": [
            "42",
            "24",
            "50"
        ],
        "correct": "1"
    },
    {
        "prompt": "Which planet is the closest to Earth?",
        "answers": [
            "Mercury",
            "Pluto",
            "Venus",
            "Jupiter",
            "Mars"
        ],
        "correct": "3"
    },
    {
        "prompt": "What is the name of Harry Potter's pet owl?",
        "answers": [
            "Henry",
            "Hagrid",
            "Hedwig"
        ],
        "correct": "3"
    },
    {
        "prompt": "How is 14 written in roman numerals?",
        "answers": [
            "XIIII",
            "IVX",
            "XXIV",
            "XIV"
        ],
        "correct": "4"
    },
    {
        "prompt": "What is the world's longest river?",
        "answers": [
            "Amazon",
            "Mississippi"
        ],
        "correct": "1"
    },
    {
        "prompt": "What is the world's largest ocean?",
        "answers": [
            "Atlantic",
            "Arctic",
            "Pacific"
        ],
        "correct": "2"
    },
    {
        "prompt": "What is the only chess piece that can move diagonally?",
        "answers": [
            "Rook",
            "Knight",
            "Bishop",
            "Pawn"
        ],
        "correct": "3"
    },
    {
        "prompt": "What does the F stand for in FBI?",
        "answers": [
            "Federal",
            "Fingers",
            "Friendly",
            "Fruit Loops",
            "Famous",
            "Faculty"
        ],
        "correct": "1"
    },
    {
        "prompt": "What kind of animal appears in the movie Free Willy?",
        "answers": [
            "Dolphin",
            "Whale",
            "Shark"
        ],
        "correct": "2"
    }
]

# Function that plays the game
def play_game():
    # Variables to keep track of user score
    questions_asked = 0
    score = 0
    # Randomizes the question order
    random.shuffle(questions)
    # Loop that changes the indexes needed from 1-4 so the user doesn't
    # Have to answer them with numbers 0-3
    for question in questions:
        print(question["prompt"])
        for i, choice in enumerate(question["answers"]):
            print(str(i + 1) + ". " + choice)
        # Loop that tells the user to enter a valid answer if user's
        # answer is out of the range 1-4
        user_answer = int(input("Choose an answer 1-4:\n"))
        while user_answer not in range(1, len(question["answers"])+1):
            user_answer = int(input("Choose an answer 1-4:\n"))
        # Checks if the answer is either correct or incorrect,
        # then prints the current score
        questions_asked += 1
        if user_answer == question["correct"]:
            score += 1
            print("Good job!")
            print(f"Your current score is {score} out of {questions_asked}")
        else:
            print("Sorry, that is incorrect.")
            print(f"Your current score is {score} out of {questions_asked}")
    # Views the credits once the user finishes, and goes back to the menu.
    view_game_credits()
    menu = input("Enter PLAY to play the game, VIEW to view the credits,"
                 " or QUIT to quit\n")
    if menu == "PLAY":
        play_game()
    elif menu == "VIEW":
        view_game_credits()
    elif menu == "QUIT":
        quit_game()

# Function that lets the user view the credits, then loops back to menu
def view_game_credits():
    print("Jordan Colebank and Ryan Demboski created this game!")
    menu = input("Enter PLAY to play the game, VIEW to view the credits,"
                 "or QUIT to quit\n")
    if menu == "PLAY":
        play_game()
    elif menu == "VIEW":
        view_game_credits()
    elif menu == "QUIT":
        quit_game()

# Function that quits the game
def quit_game():
    print("Thanks for playing!")

# The menu the user sees when first starting up the program, and the
# choice the user picks decides which function gets ran.
print("Welcome to this super amazing trivia game show!")
menu = input("Enter PLAY to play the game, VIEW to view the credits,"
             "or QUIT to quit\n")

if menu == "PLAY":
    play_game()
elif menu == "VIEW":
    view_game_credits()
elif menu == "QUIT":
    quit_game()
