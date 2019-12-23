#The story is about the player being lost in the woods 
#and needs to make the correct choices to meet up with your friends.

print("You were hiking on a trail in the woods with your friends")
print("but along the way you got split up.")
print("You are now lost in these woods, and")
print("you need to decide which direction to go.")

choice = input("Do you turn LEFT, continue STRAIGHT ahead, or turn RIGHT?")

#.lower() was used in the if statements so the player could 
#choose to type in their answer in upper or lower case.

if choice == "LEFT".lower():
    print("After a couple minutes of walking, you discover")
    print("a large ravine with a river at the bottom.")
    print("Near the ravine, you notice an old raft.")

#the \n in our strings was used to seperate the string into another line to keep it under 75 characters.

    raft = input("Do you want to TAKE a chance and use the raft? Or do you\nwant to IGNORE it and go around?")
    if raft == "TAKE".lower():
        print("You decide to use the raft.")
        print("Luckily for you, the raft didn't break.")
        print("And you made it across the river successfully.")
        print("Which led you to your friends!")
    else:
        print("You don't take the raft, and choose to go around.")
        print("While walking around the ravine, you slip on a rock")
        print(" and fall 500 feet into the ravine and die.")

elif choice == "STRAIGHT".lower():
    print("You continue walking straight")
    print("and after a few minutes you see a shadow.")
    print("It is moving. You think it might be one of your friends.")

    shadow = input("Do you FOLLOW the shadow,\nor do you IGNORE it and go around?")
    if shadow == "FOLLOW".lower():
        print("You decide to follow the shadow.")
        print("But to your surprise, it wasn't your friend...")
        print("The shadow was actually a bear!")
        print("Luckily, it hasn't noticed you yet.")

        bear = input("Do you RUN from the bear,\nor do you attempt to SNEAK away?")

        if bear == "SNEAK".lower():
            print("You were able to sneak away unharmed.")
            print("After escaping the bear, you found your friends!")
        else:
            print("You run and the bear notices you")
            print("The bear attacks you and you die.")
        
    else:
        print("You don't follow the shadow.")
        print("You continue walking and find your friends")


else:
    print("You decide to turn right.") 
    print("You discover a pile of matches on the ground.")
    print("You were trying to start a fire to get your friends")
    print("attention. A elk ran by and you drop the matches.")

    matches = int(input("How many matches do you pick up? Pick 1-5 "))

    if matches > 3:
        print("You were able to start a fire and your friends found you!")

    else:
        print("All the matches were unable to start the fire.")
        print("You are stuck here forever and were never found.")