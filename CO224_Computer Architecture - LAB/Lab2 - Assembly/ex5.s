@ ARM Assembly - exercise 5
@ 
@ Roshan Ragel - roshanr@pdn.ac.lk
@ Hasindu Gamaarachchi - hasindu@ce.pdn.ac.lk

	.text 	@ instruction memory
	.global main
main:
	@ stack handling, will discuss later
	@ push (store) lr to the stack
	sub sp, sp, #4
	str lr, [sp, #0]

	@ load values
	@ a,b,i,j in r0,r1,r2,r3 respectively
	mov r0, #10
	mov r1, #5
	mov r2, #7
	mov r3, #-8

	
	@ Write YOUR CODE HERE
	
	@ j=0;
	@ for (i=0;i<10;i++)
	@ 		j+=i;	
	
	@ Put final j to r5

	@ ---------------------

	mov r5,#0
	mov r4,#0
	
loop:
	cmp r4,#10
	blt body
	
	b exit
body:	
	add r5,r5,r4
	add r4,r4,#1
	b loop
	
exit:

	@ ---------------------
	
	
	@ load aguments and print
	ldr r0, =format
	mov r1, r5
	bl printf

	@ stack handling (pop lr from the stack) and return
	ldr lr, [sp, #0]
	add sp, sp, #4
	mov pc, lr

	.data	@ data memory
format: .asciz "The Answer is %d (Expect 45 if correct)\n"

