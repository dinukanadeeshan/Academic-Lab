// a clock with a period of 5 time units

module clock_simulation;

reg clock;

initial
begin
	clock = 1'b0;
	#5 clock = 1'b1;
	#5 clock = 1'b0;
	#5 clock = 1'b1;
	#5 clock = 1'b0;
	#5 $finish;
end

endmodule




