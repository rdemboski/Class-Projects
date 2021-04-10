#Author: Ryan Demboski
#Date: 3/7/2020
#Program: Assembly Program 1A
#Class: CS200-001


    .data


msg1: .asciiz "Enter an integer "         #User input for first number
msg2: .asciiz "Enter a second integer "   #User input for second number
msg3: .asciiz "Enter a third integer "    #User input for third number
result: .asciiz "result is: "             #Result string


    .text
    .globl main


main:


    li $v0, 4       #Syscall code to read a string
    la $a0, msg1    #Takes address of string from msg1
    syscall         #Prints msg1

    
    li $v0, 5       #Syscall code to read the integer from msg1
    syscall         #Actually Read the integer
    move $t1, $v0   #Move integer to t1


    li $v0, 4       #Syscall code to read a string
    la $a0, msg2    #Takes address of string from msg2
    syscall         #Prints msg2


    li $v0, 5       #Syscall code to read the integer from msg2
    syscall         #Actually read the integer
    move $t2, $v0   #Move integer to t2


    sub $t3, $t1, $t2   #Subtract num1 and num2, store in register t3


    li $v0, 4       #Syscall code to read the string from msg3
    la $a0, msg3    #Takes address of string from msg3
    syscall         #Prints msg3


    li $v0, 5       #Syscall code to read the integer from msg3
    syscall         #Actually read the integer
    move $t4, $v0   #Moves integer to t4


    add $t5, $t4, $t3   #Add num 3 to the result of the subtraction, store in register t5


    li $v0, 4       #Syscall code to read string from result
    la $a0, result  #Takes address of string from result
    syscall         #Prints result string (ONLY 'result: is ')


    li $v0, 1       #Syscall code to print an integer from result
    move $a0, $t5   #Takes address of final result integer
    syscall         #Prints integer result value


    li $v0, 10      #Syscall for exit program
    syscall         #Carry out the exit command