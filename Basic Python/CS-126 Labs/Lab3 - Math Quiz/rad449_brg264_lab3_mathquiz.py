#Lab 3 Math Quiz
#Ryan Demboski, Brandon Gonzalez
#9/23/19
#Section 001

#Grabbed the randint function from python's library
from random import randint

#Global variables to keep count of the user's score for the final score.
correct = 0
questions_asked = 0

#Stored the user's difficulty choice in the variable below
lvl_choice = int(input("What quiz? easy(0) intermediate(1) advanced(2) "))

#Stored the user's desired question amount in thw variable below
questions = int(input("How many questions would you like? "))

#Used a single while loop with an if statement deciding the difficulty 
#Based on the level_choice value provided by the user
while questions_asked <= questions:
    if lvl_choice == 0:
        n1 = randint(1, 10)
        n2 = randint(1,10)
        choice = randint(1,2)
        #Choice is what randomly determines the artithmitic expression used
        if choice == 1:
            calculated_answer = n1 + n2
        elif choice == 2:
            calculated_answer = n1 - n2
        #Choice is then again used to ask for the answer of that expression
        if choice == 1:   
            user_answer = int(input(f"What's {n1} plus {n2}? "))
        elif choice == 2:
            user_answer = int(input(f"What's {n1} minus {n2}? "))
        
        if user_answer == calculated_answer:
            print("That's correct!")
            #Increase user's score by 1
            correct += 1
        else:
            print(f"Wrong. The answer is {calculated_answer}.\n ")
            #Increases incorrect answer by 1
            questions_asked += 1

    elif lvl_choice == 1:
        n1 = randint(1, 25)
        n2 = randint(1,25)
        #Choice now has 4 to also include multiplication and division
        choice = randint(1,4)
        if choice == 1:
            calculated_answer = n1 + n2
        elif choice == 2:
            calculated_answer = n1 - n2
        elif choice == 3:
            calculated_answer = n1 * n2
        elif choice == 4:
            #Used round() to keep the solution to 2 decimal places
            calculated_answer = round(n1 / n2, 2)

        if choice == 1:   
            user_answer = int(input(f"What's {n1} plus {n2}? "))
        elif choice == 2:
            user_answer = int(input(f"What's {n1} minus {n2}? "))
        elif choice == 3:
            user_answer = int(input(f"What's {n1} times {n2}? "))
        elif choice == 4:
            #This time float is used to allow for decimal answers
            user_answer = float(input(f"What's {n1} divided by {n2}? "))
        if user_answer == calculated_answer:
            print("That's correct!")
            correct += 1
        else:
            print(f"Wrong. The answer is {calculated_answer}.\n")
            questions_asked += 1

    elif lvl_choice == 2:
        n1 = randint(1, 25)
        n2 = randint(1,25)
        n3 = randint(1,5)
        choice = randint(1,4)
        if choice == 1:
            calculated_answer = n1 + n2 * n3
        elif choice == 2:
            calculated_answer = round(n1 - n2 / n3, 2)
        elif choice == 3:
            calculated_answer = n1 * n2 + n3
        elif choice == 4:
            calculated_answer = round(n1 / n2 - n3, 2)

        if choice == 1:   
            user_answer = int(input(f"What's {n1} plus {n2} times {n3}? "))
        elif choice == 2:
            user_answer = float(input(f"{n1} minus {n2} divided by {n3}? "))
        elif choice == 3:
            user_answer = int(input(f"What's {n1} times {n2} plus {n3}? "))
        elif choice == 4:
            user_answer = float(input(f"{n1} divided by {n2} minus {n3}? "))
        if user_answer == calculated_answer:
            print("That's correct!")
            correct += 1
        else:
            print(f"Wrong. The answer is {calculated_answer}.\n")
            questions_asked += 1

    #Conditional to decide what message is displayed based on score
    if correct > questions_asked:
        print("Well done!")
    elif correct == questions_asked:
        print("You need more practice.")
    elif correct < questions_asked:
        print("Please ask your math teacher for help!")
