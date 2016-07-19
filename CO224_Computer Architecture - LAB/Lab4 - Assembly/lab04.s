.text	

	
	.global main
main:
	
	sub	sp, sp, #104
	str	lr, [sp, #100]
	
	@printf for string
	@ldr	r0, =formatr
	@bl	printf
	
	@scanf for string
	ldr	r0, =formats
	mov	r1, sp
	bl	scanf	@scanf("%s",sp)

	@function call
	mov	r0, sp
	bl	stringLen
	

	sub sp,sp,#4
	str r0,[sp,#0]
	@print answer
	add	r1, sp,#4
	mov	r2, r0
	ldr	r0, =formatp
	bl	printf

	ldr r0,[sp,#0]
	add sp,sp,#4

	mov r3,r0

loopx:
	sub r3,r3,#1


	ldr	r1, [sp,r3]
	sub sp,sp,#4
	str r3,[sp,#0]
	ldr	r0, =formatc
	bl	printf
	ldr r3,[sp,#0]
	add sp,sp,#4

	cmp r3,#0
	bge loopx



    @ stack handling (pop lr from the stack) and return
	mov	r0, #0		@return 0
	ldr	lr, [sp, #100]
	add	sp, sp, #104
	mov	pc, lr		





	@ string length function
stringLen:
	sub	sp, sp, #4
	str	lr, [sp, #0]

	mov	r1, #0	@ length counter

loop:
	ldrb	r2, [r0, #0]
	cmp	r2, #0
	beq	endLoop

	add	r1, r1, #1	@ count length
	add	r0, r0, #1	@ move to the next element in the char array
	b	loop

endLoop:
	mov	r0, r1		@ to return the length
	ldr	lr, [sp, #0]
	add	sp, sp, #4
	mov	pc, lr

	


exit:

	.data	@ data memory
formatr: .asciz "Enter a string: "
formats: .asciz "%s"
formatd: .asciz "%d"
formatc: .asciz "%c"

formatp: .asciz "The length of %s is %d\n"
format1: .asciz "Enter the number of strings: "
