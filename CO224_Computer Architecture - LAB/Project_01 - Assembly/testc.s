	.file	"testc.c"
	.def	___main;	.scl	2;	.type	32;	.endef
	.section .rdata,"dr"
LC0:
	.ascii "Enter the key:\0"
LC1:
	.ascii "%16llx %16llx\0"
LC2:
	.ascii "Enter the plain text:\0"
LC3:
	.ascii "%16llx %16llx\12\0"
	.text
	.globl	_main
	.def	_main;	.scl	2;	.type	32;	.endef
_main:
LFB10:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	pushl	%edi
	pushl	%esi
	pushl	%ebx
	andl	$-16, %esp
	addl	$-128, %esp
	.cfi_offset 7, -12
	.cfi_offset 6, -16
	.cfi_offset 3, -20
	call	___main
	movl	$LC0, (%esp)
	call	_puts
	leal	104(%esp), %eax
	movl	%eax, 8(%esp)
	leal	112(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$LC1, (%esp)
	call	_scanf
	movl	$LC2, (%esp)
	call	_puts
	leal	88(%esp), %eax
	movl	%eax, 8(%esp)
	leal	96(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$LC1, (%esp)
	call	_scanf
	movl	96(%esp), %eax
	movl	100(%esp), %edx
	movl	%eax, %ebx
	shrdl	$8, %edx, %eax
	shrdl	$8, %ebx, %edx
	movl	%eax, 96(%esp)
	movl	%edx, 100(%esp)
	movl	96(%esp), %ecx
	movl	100(%esp), %ebx
	movl	88(%esp), %eax
	movl	92(%esp), %edx
	addl	%ecx, %eax
	adcl	%ebx, %edx
	movl	%eax, 96(%esp)
	movl	%edx, 100(%esp)
	movl	96(%esp), %ecx
	movl	100(%esp), %ebx
	movl	104(%esp), %eax
	movl	108(%esp), %edx
	movl	%eax, 72(%esp)
	movl	%edx, 76(%esp)
	movl	%ecx, %eax
	xorl	72(%esp), %eax
	movl	%eax, %esi
	movl	%ebx, %eax
	xorl	76(%esp), %eax
	movl	%eax, %edi
	movl	%esi, 96(%esp)
	movl	%edi, 100(%esp)
	movl	88(%esp), %eax
	movl	92(%esp), %edx
	movl	%eax, %edi
	shldl	$3, %edx, %eax
	shldl	$3, %edi, %edx
	movl	%eax, 88(%esp)
	movl	%edx, 92(%esp)
	movl	96(%esp), %ecx
	movl	100(%esp), %ebx
	movl	88(%esp), %eax
	movl	92(%esp), %edx
	movl	%ecx, %edi
	xorl	%eax, %edi
	movl	%edi, 64(%esp)
	xorl	%edx, %ebx
	movl	%ebx, 68(%esp)
	movl	64(%esp), %eax
	movl	68(%esp), %edx
	movl	%eax, 88(%esp)
	movl	%edx, 92(%esp)
	movl	$0, 124(%esp)
	jmp	L2
L3:
	movl	112(%esp), %eax
	movl	116(%esp), %edx
	movl	%eax, %edi
	shrdl	$8, %edx, %eax
	shrdl	$8, %edi, %edx
	movl	%eax, 112(%esp)
	movl	%edx, 116(%esp)
	movl	112(%esp), %ecx
	movl	116(%esp), %ebx
	movl	104(%esp), %eax
	movl	108(%esp), %edx
	addl	%ecx, %eax
	adcl	%ebx, %edx
	movl	%eax, 112(%esp)
	movl	%edx, 116(%esp)
	movl	124(%esp), %eax
	movl	%eax, %ecx
	movl	%eax, %ebx
	sarl	$31, %ebx
	movl	112(%esp), %eax
	movl	116(%esp), %edx
	movl	%ecx, %esi
	xorl	%eax, %esi
	movl	%esi, 56(%esp)
	xorl	%edx, %ebx
	movl	%ebx, 60(%esp)
	movl	56(%esp), %eax
	movl	60(%esp), %edx
	movl	%eax, 112(%esp)
	movl	%edx, 116(%esp)
	movl	104(%esp), %eax
	movl	108(%esp), %edx
	movl	%eax, %edi
	shldl	$3, %edx, %eax
	shldl	$3, %edi, %edx
	movl	%eax, 104(%esp)
	movl	%edx, 108(%esp)
	movl	104(%esp), %ecx
	movl	108(%esp), %ebx
	movl	112(%esp), %eax
	movl	116(%esp), %edx
	movl	%ecx, %edi
	xorl	%eax, %edi
	movl	%edi, 48(%esp)
	xorl	%edx, %ebx
	movl	%ebx, 52(%esp)
	movl	48(%esp), %eax
	movl	52(%esp), %edx
	movl	%eax, 104(%esp)
	movl	%edx, 108(%esp)
	movl	96(%esp), %eax
	movl	100(%esp), %edx
	movl	%eax, %esi
	shrdl	$8, %edx, %eax
	shrdl	$8, %esi, %edx
	movl	%eax, 96(%esp)
	movl	%edx, 100(%esp)
	movl	96(%esp), %ecx
	movl	100(%esp), %ebx
	movl	88(%esp), %eax
	movl	92(%esp), %edx
	addl	%ecx, %eax
	adcl	%ebx, %edx
	movl	%eax, 96(%esp)
	movl	%edx, 100(%esp)
	movl	96(%esp), %ecx
	movl	100(%esp), %ebx
	movl	104(%esp), %eax
	movl	108(%esp), %edx
	movl	%ecx, %esi
	xorl	%eax, %esi
	movl	%esi, 40(%esp)
	movl	%ebx, %edi
	xorl	%edx, %edi
	movl	%edi, 44(%esp)
	movl	40(%esp), %eax
	movl	44(%esp), %edx
	movl	%eax, 96(%esp)
	movl	%edx, 100(%esp)
	movl	88(%esp), %eax
	movl	92(%esp), %edx
	movl	%eax, %edi
	shldl	$3, %edx, %eax
	shldl	$3, %edi, %edx
	movl	%eax, 88(%esp)
	movl	%edx, 92(%esp)
	movl	96(%esp), %ecx
	movl	100(%esp), %ebx
	movl	88(%esp), %eax
	movl	92(%esp), %edx
	movl	%ecx, %esi
	xorl	%eax, %esi
	movl	%esi, 32(%esp)
	xorl	%edx, %ebx
	movl	%ebx, 36(%esp)
	movl	32(%esp), %eax
	movl	36(%esp), %edx
	movl	%eax, 88(%esp)
	movl	%edx, 92(%esp)
	addl	$1, 124(%esp)
L2:
	cmpl	$30, 124(%esp)
	jle	L3
	movl	88(%esp), %ecx
	movl	92(%esp), %ebx
	movl	96(%esp), %eax
	movl	100(%esp), %edx
	movl	%ecx, 12(%esp)
	movl	%ebx, 16(%esp)
	movl	%eax, 4(%esp)
	movl	%edx, 8(%esp)
	movl	$LC3, (%esp)
	call	_printf
	movl	$0, %eax
	leal	-12(%ebp), %esp
	popl	%ebx
	.cfi_restore 3
	popl	%esi
	.cfi_restore 6
	popl	%edi
	.cfi_restore 7
	popl	%ebp
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE10:
	.ident	"GCC: (GNU) 4.8.1"
	.def	_puts;	.scl	2;	.type	32;	.endef
	.def	_scanf;	.scl	2;	.type	32;	.endef
	.def	_printf;	.scl	2;	.type	32;	.endef
