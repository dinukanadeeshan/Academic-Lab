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
 
	ldr r1,[sp,#16]
	ldr r2, [sp,#20]
	
	bl logical_r_shift_8 	@p_1 = (p_1 >> 8)|(p_1 << (64 - 8));
	str r1,[sp,#16]
	str r2, [sp,#20]
	
	

	ldr r1,[sp,#16]
	ldr r2, [sp,#20]
	ldr r3, [sp,#24]
	ldr r4, [sp,#28]
	bl addition				@p_1 += p_2;
	str r1,[sp,#16]
	str r2, [sp,#20]
	str r3, [sp,#24]
	str r4, [sp,#28]	
	
	
	ldr r3,[sp,#8]
	ldr r4, [sp,#12]
	bl eor_for_other
	str r1,[sp,#16]
	str r2,[sp,#20]


	ldr r1,[sp,#24]
	ldr r2,[sp,#28]
	bl logical_l_shift_3
	str r1,[sp,#24]
	str r2,[sp,#28]
	
	
	ldr r1,[sp,#24]
	ldr r2, [sp,#28]
	ldr r3,[sp,#16]
	ldr r4, [sp,#20]
	bl eor_for_other

	str r1,[sp,#24]
	str r2, [sp,#28]
	ldr r0, =formatllx_
	bl printf

	
	mov r7, #0
	
	
main_loop:
	cmp r7, #31
	bge end_loop
	
	ldr r1, [sp,#0]
	ldr r2, [sp,#4]
	bl logical_r_shift_8 	@k_1 = (k_1 >> 8)|(k_1 << (64 - 8));
	str r1, [sp,#0]
	str r2, [sp,#4]
	
	ldr r1, [sp,#0]
	ldr r2, [sp,#4]
	ldr r3, [sp,#8]
	ldr r4, [sp,#12]
	
	bl addition
	str r1, [sp,#0]
	str r2, [sp,#4]
	
	ldr r1, [sp,#4] @this have to check if ans not get [sp,#0]
	mov r2,r7
	bl eor_for_i
	str r1, [sp,#4]

	ldr r1, [sp,#8]
	ldr r2, [sp,#12]
	bl logical_l_shift_3
	str r1, [sp,#8]
	str r2, [sp,#12]
	
	ldr r3, [sp,#0]
	ldr r4, [sp,#4]
	bl eor_for_other
	
	str r1, [sp,#8]
	str r2, [sp,#12]
	
	
	ldr r1,[sp,#16]
	ldr r2, [sp,#20]
	ldr r3, [sp,#24]
	ldr r4, [sp,#28]	
	bl logical_r_shift_8 	@p_1 = (p_1 >> 8)|(p_1 << (64 - 8));
	str r1,[sp,#16]
	str r2, [sp,#20]
	str r3, [sp,#24]
	str r4, [sp,#28]	
	

	ldr r1,[sp,#16]
	ldr r2, [sp,#20]
	bl addition				@p_1 += p_2;
	str r1,[sp,#16]
	str r2, [sp,#20]


	
	ldr r3,[sp,#8]
	ldr r4, [sp,#12]
	bl eor_for_other
	str r1,[sp,#16]
	str r2,[sp,#20]


	ldr r1,[sp,#24]
	ldr r2, [sp,#28]
	bl logical_l_shift_3
	str r1,[sp,#24]
	str r2, [sp,#28]

	ldr r1,[sp,#24]
	ldr r2, [sp,#28]
	ldr r3,[sp,#16]
	ldr r4, [sp,#20]
	bl eor_for_other

	str r1,[sp,#24]
	str r2, [sp,#28]

	
	add r7,r7,#1
	
	b main_loop
end_loop:
	@print the final answer
	ldr r0, =formatllx_
	ldr r1,[sp,#16]
	ldr r2,[sp,#20]
	bl printf

	ldr r0, =formatllx_
	ldr r1,[sp,#24]
	ldr r2,[sp,#28]
	bl printf
	b exit

exit:
	mov r0,#0
	ldr lr, [sp,#32]
	add sp,sp,#36
	mov pc,lr

eor_for_i:
	sub sp,sp,#4
	str lr, [sp]
	
	eor r1,r1,r2
	
	ldr lr, [sp]
	add sp,sp,#4
	
eor_for_other:

	sub sp,sp,#4
	str lr, [sp]
	
	eor r1,r1,r3
	eor r2,r2,r4
	
	ldr lr, [sp]
	add sp,sp,#4


addition:
	sub sp,sp,#4
	str lr, [sp]
	
	adds r1,r1,r3
	adc r2,r2,r4

	ldr lr, [sp]
	add sp,sp,#4
	mov pc,lr
	
	
logical_r_shift_8:
	sub sp,sp,#16
	str lr, [sp]
	str r5, [sp,#4]
	str r4, [sp,#8]
	str r6, [sp,#12]
	
	mov r5,#0	@r5 for loop run
loop_for_r_shift:
	cmp r5, #8
	beq logical_r_shift_8_end	@end for the loop
	
	@loop body
	and r4,r1,#1
	and r6,r2,#1
	
	lsr r1,r1,#1
	lsr r2,r2,#1
	@cmp r4, #1  @check for whether there is carry when shift
	lsl r4,r4,#31
	lsl r6,r6,#31
	
	adds r2,r2,r4
	adc r1,r1,r6
	
	add r5,r5,#1
	b loop_for_r_shift


	
logical_r_shift_8_end:
	
	
	ldr lr, [sp]
	ldr r5, [sp,#4]
	ldr r4, [sp,#8]
	ldr r6, [sp,#12]
	add sp,sp,#16
	mov pc,lr


logical_l_shift_3:
	sub sp,sp,#16
	str lr, [sp]
	str r5, [sp,#4]
	str r4, [sp,#8]
	str r6, [sp,#12]
	
	mov r5,#0	@r5 for loop run
loop_for_l_shift:
	cmp r5, #3
	beq logical_l_shift_3_end	@end for the loop
	
	@loop body
	mov r4,#1
	mov r6,#1
	lsl r4,r4,#31
	lsl r6,r6,#31
	and r4,r1,r4
	and r6,r2,r6
	
	
	lsl r1,r1,#1
	lsl r2,r2,#1
	
	@cmp r4, #1  @check for whether there is carry when shift
	lsr r4,r4,#31
	lsr r6,r6,#31
	
	
	
	add r1,r1,r6
	add r2,r2,r4
	
	add r5,r5,#1
	b loop_for_l_shift
	
logical_l_shift_3_end:
	
	ldr lr, [sp]
	ldr r5, [sp,#4]
	ldr r4, [sp,#8]
	ldr r6, [sp,#12]
	add sp,sp,#16
	mov pc,lr

	@TEST CODES =====================================
	@sub sp,sp,#4
	@str r1,[sp]
	@ldr r0, =formatllx_
	@mov r1,r2
	@bl printf
	@ldr r1, [sp]
	@add sp,sp,#4
	

.data
input_text_1: .asciz "Enter the key:\n"
input_text_2: .asciz "Enter the plain text:\n"
formatllx_: .asciz "%016llx "
formatllx: .asciz "%16llx %16llx"
format: .asciz "%08x\n"
testFormat: .asciz "Passed\n"
