# LAB 6 banners
# Eduardo Martinez and Ryan Demboski
# 10/21/19
# section: 001


letters = {
    'A' : [" AA ",
           "A  A",
           "AAAA",
           "A  A"],

    'B' : ["BBB ",
           "B__B",    
           "B  B",
           "BBB"],

    'C' : ["CCCC",
           "C   ",
           "C   ",
           "CCCC"],
           
    'D' : ["DDD ",
           "D  D",
           "D  D",
           "DDD "],
           
    'E' : ['EEEE',
           'E__ ',
           'E   ',
           'EEEE'],
           
    'F' : ['FFFF',
           'F   ',
           'FFF ',
           'F   '],
           
    'G' : ['GGGG',
           'G   ',
           'G GG',
           'GGGG'],

    'H' : ['H  H',
           'HHHH',
           'HHHH',
           'H  H'],
           
    'I' : ['IIII',
           ' II ',
           ' II ',
           'IIII'],
           
    'J' : ['JJJJ',
           '   J',
           'J  J',
           ' JJ '],
           
    'K' : ['K  K',
           'KKK ',
           'KKL ',
           'K  K'],
           
    'L' : ['L   ',
           'L   ',
           'L   ',
           'LLLL'],

    'M' : ['M  M',
           'MMMM',
           'M  M',
           'M  M'],
           
    'N' : ['N  N',
           'NN N',
           'N NN',
           'N  N'],
           
    'O' : ['OOOO',
           'O  O',
           'O  O',
           'OOOO'], 
           
    'P' : ['PPPP',
           'P  P',
           'PPPP',
           'P   '],

    'Q' : ['QQQQ',
           'Q  Q',
           'QQQQ',
           '   Q'],

    'R' : ['RRR ',
           'R  R',
           'RRR ',
           'R  R'],

    'S' : ['SSSS',
           'SS  ',
           '  SS',
           'SSSS'],

    'T' : ['TTTT',
           ' TT ',
           ' TT ',
           ' TT '],
           
    'U' : ['U  U',
           'U  U',
           'U  U',
           'UUUU'],

    'V' : ['V  V',
           'V  V',
           'V  V',
           ' VV '],

    'W' : ['W  W',
           'W  W',
           'WWWW',
           'W  W'],

    'X' : ['X  X',
           ' XX ',
           ' XX ',
           'X  X'],

    'Y' : ['Y  Y',
           'Y  Y',
           ' YY ',
           ' YY '],

    'Z' : ['ZZZZ',
           '  Z ',
           ' Z  ',
           'ZZZZ']
}
#This fucntions usings a string and direction parameter
#it calls either our vertical function or horizontal

def print_banner(string, direction):
    if direction == 'vertical':
        vertical_print_banner(string)
    else:
        horizonal_print_banner(string)
        
# vertical function: has a nested while loop
# the first part of the while loop prit out the 
# length of the word, the second part print out the
# dictionary keys assoictated with the letters vertically 
# and puts them into an acccumulator

def vertical_print_banner(string):
    g = 0
    while g < len(string):
        i = 0
        while i < 4:
            x = letters[str(string[g])][i]
            print(x)
            i = i + 1
        g = g + 1
        
# horizontal funtion: has a nested loop as the vertical function
# with the second while loop we set up two variable to slice the strng of the word
# allowing it to print horizontally and put it into the accumulator

def horizonal_print_banner(string):
    i = 0
    h = 0
    liner = ""
    while i < 4:
        while h < len(string):
            letter = string[h]
            asc = letters[letter][i] 
            liner = liner + " " + asc
            h = h + 1
        print(liner)
        liner = ""
        h = 0
        i = i + 1
