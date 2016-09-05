module clock_always;

reg clock;


initial
	clock = 1'b0;

always
	#5 clock = ~clock;

initial
	#25 $finish;

endmodule
