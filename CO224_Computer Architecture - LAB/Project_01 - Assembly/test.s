.text
.global main

main:
	sub sp,sp,#36
	str lr, [sp,#32]

	@Scan two keys
	ldr r0, =input_text_1
	bl printf

	ldr r0, =formatllx
	mov r1,sp
	add r2,sp,#8
	bl scanf


	@Scan two plain texts
	ldr r0, =input_text_2
	bl printf

	ldr r0, =formatllx
	add r1, sp, #16
	add r2, sp, #24
	bl scanf


	

	@print the final answer
	ldr r0, =formatllx_
	ldr r1,[sp,#0]
	ldr r2,[sp,#4]
	bl printf

	ldr r0, =formatllx_
	ldr r1,[sp,#8]
	ldr r2,[sp,#12]
	bl printf
	b exit

exit:
	mov r0,#0
	ldr lr, [sp,#32]
	add sp,sp,#36
	mov pc,lr

logical_r_shift_8:
	sub sp,sp,#4
	str lr, [sp]



logical_r_shift_8_end:
	add sp,sp,#4
	ldr lr, [sp]
	mov pc,lr


logical_l_shift_3:
	sub sp,sp,#4
	str lr,[sp]



logical_l_shift_3_end:
	add sp,sp, #4
	ldr lr,[sp]
	mov pc, lr


.data
input_text_1: .asciz "Enter the key:\n"
input_text_2: .asciz "Enter the plain text:\n"
formatllx_: .asciz "%16llx"
formatllx: .asciz "%16llx %16llx"
formatllxx: .asciz "%x%x "
formatllxx_: .asciz "%x%x"
