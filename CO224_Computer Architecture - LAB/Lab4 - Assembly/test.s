
	.text	
	
	.global main
main:
	@ stack handling
	@ push (store) lr to the stack
	sub	sp, sp, #54
	str	lr, [sp, #50]


	@printf for input
	ldr	r0, =formatr
	bl 	printf


	ldr r0, =formatc
	mov r1, sp
	bl scanf

@loop:
@	ldr r0, =formatd
@	ldr r1,[sp]
@	cmp r1,#0
@	beq exit
@	bl printf

exit:


    @ stack handling (pop lr from the stack) and return
	ldr	lr, [sp, #50]
	add	sp, sp, #54
	mov	pc, lr		
	
	
	.data	@ data memory
formatr: .asciz "Hello\n"
formatc: .asciz "%c"
formatd: .asciz "%d"
