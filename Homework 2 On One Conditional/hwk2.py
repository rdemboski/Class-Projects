# !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!!
# You should NOT use the print() or input() functions anywhere in this homework!
# !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!!


# Function 0: Seconds into days, hours, minutes, and seconds

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

def metricifier(quantity, flag):
    if flag == 0:
        return (quantity -32)*5/9
    elif flag == 1:
        return (quantity)/3.281
    elif flag == 2:
        return (quantity)/0.453592
    else:
        return quantity * 3.78541

# Function 2: Valid triangle detector

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

def find_rps_outcome(player1,player2):
    if player1 == player2:
        return "Tie game"
    elif player1 == "rock" and player2 == "scissors":
        return "Player 1 wins"
    elif player1 == "scissors" and player2 == "paper":
        return "Player 1 wins"
    elif player1 == "paper" and player2 == "rock":
        return "Player 1 wins"
    else:
        return "Player 2 wins"

