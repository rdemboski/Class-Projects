#Author: Ryan Demboski
#Date: 3/26/2020
#Program: Project 2 - Array Traversal
#Class: CS200-001

.data

.align 4
    loop: .space 24
    #enter one number at a time for the array in the spim console
    numArray: .asciiz ""
    msg2: .asciiz "  "
    msg3: .asciiz "\n"
    size: .word 5

.text
.globl main

main:

    addi $s0, $zero, 5
    addi $t0, $zero, 0

hold:
    li $v0, 4
    la $a0, numArray
    syscall
    li $v0, 5
    syscall
    add $t1, $t0, $zero
    sll $t1, $t0, 2
    add $t3, $v0, $zero
    sw $t3, loop($t1)
    addi $t0, $t0, 1
    slt $t1, $s0, $t0
    beq $t1, $zero, hold

    la $a0, loop
    addi $a1, $s0, 1 #a1 = 6
    #call bubble_sort
    jal bubble_sort

    #print loop
    li $v0, 4
    la $a0, msg3
    syscall
    la $t0, loop
    #s0 = 5
    add $t1, $zero, $zero

printloop:
    lw $a0, 0($t0)
    li $v0, 1
    syscall
    li $v0, 4
    la $a0, msg2
    syscall
    addi $t0, $t0, 4
    addi $t1, $t1, 1
    slt $t2, $s0, $t1
    beq $t2, $zero, printloop

    li $v0, 10
    syscall

bubble_sort:
    #a0 = address of loop
    #a1 = sizeof loop
    add $t0, $zero, $zero #inIndex( index ) = 0

    loop1:
        addi $t0, $t0, 1 #inIndex++
        bgt $t0, $a1, endloop1 #if t0 < a1;

        add $t1, $a1, $zero #index = size = 6

        loop2:
            bge $t0, $t1, loop1 #index <= inIndex

            #slt $t3, $t1, $t0
            #bne $t3, $zero, loop1

            addi $t1, $t1, -1 #index--

            mul $t4, $t1,4 #t4 + a0 = loop[index]
            addi $t3, $t4, -4 #t3 + a0 = loop[index-1]
            add $t7, $t4, $a0 #t7 = loop[index]
            add $t8, $t3, $a0 #t8 = loop[index-1]
            lw $t5, 0($t7)
            lw $t6, 0($t8)

            bgt $t5, $t6, loop2

            #switch t5, t6
            sw $t5, 0($t8)
            sw $t6, 0($t7)
            j loop2

    endloop1:
        jr $ra
