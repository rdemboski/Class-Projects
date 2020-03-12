#Author: Ryan Demboski
#Date: 3/7/2020
#Program: Assembly Program 1A
#Class: CS200-001


    .data

num1: .word 0   #Label for first number
num2: .word 0   #Label for second number
num3: .word 0   #Label for third number
temp: .word 0   #Label for result of subtraction
result: .word 0 #Label for result integer

msg1: .asciiz "Enter an integer "         #User input for first number
msg2: .asciiz "Enter a second integer "   #User input for second number
msg3: .asciiz "Enter a third integer "    #User input for third number
resultMsg: .asciiz "result is: "          #Result string


    .text
    .globl main


main:


    li $v0, 4       #Syscall code to read a string
    la $a0, msg1    #Takes address of string from msg1
    syscall         #Prints msg1

    
    li $v0, 5       #Syscall code to read the integer from msg1
    syscall         #Actually Read the integer
    sw $v0, num1    #Stores value of num1


    li $v0, 4       #Syscall code to read a string
    la $a0, msg2    #Takes address of string from msg2
    syscall         #Prints msg2


    li $v0, 5       #Syscall code to read the integer from msg2
    syscall         #Actually read the integer
    sw $v0, num2    #Stores value of num2

    lw $t1, num1    #Load value of num1, preparing for subtraction
    lw $t2, num2    #Load value of num2, preparing for subtraction

    sub $t3, $t1, $t2   #Subtract num1 and num2, store in register t3
    sw $t3, temp        #Store value of subtraction into temporary label

    li $v0, 4       #Syscall code to read the string from msg3
    la $a0, msg3    #Takes address of string from msg3
    syscall         #Prints msg3


    li $v0, 5       #Syscall code to read the integer from msg3
    syscall         #Actually read the integer
    sw $v0, num3    #Store value of num3

    lw $t3, temp    #Load result of subtraction, preparing for addition
    lw $t4, num3    #Load num3, preparing for addition

    add $t5, $t4, $t3   #Add num3 to the result of the subtraction
    sw $t5, result      #Store result of addition into the result label

    li $v0, 4       #Syscall code to read string from result
    la $a0, resultMsg  #Takes address of string from result
    syscall         #Prints result string (ONLY 'result: is ')


    li $v0, 1       #Syscall code to print an integer from result
    lw $a0, result  #Loads the result integer label address, for the syscall
    syscall         #Prints integer result value


    li $v0, 10      #Syscall for exit program
    syscall         #Carry out the exit command