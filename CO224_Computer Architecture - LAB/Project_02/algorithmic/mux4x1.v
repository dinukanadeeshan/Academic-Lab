// Define the stimulus module (no ports)
module stimulus;

	// Declare variables to be connected
	// to inputs
	reg IN0, IN1, IN2, IN3;
	reg S1, S0;
	
	// Declare output wire
	wire OUTPUT;
	
	// Instantiate the multiplexer
	mux4_to_1 mymux(OUTPUT, IN0, IN1, IN2, IN3, S1, S0);
	
	// Stimulate the inputs
	// Define the stimulus module (no ports)
	initial
	begin
		// set input lines
		IN0 = 1; IN1 = 0; IN2 = 1; IN3 = 0;
		#1 $display("IN0= %b, IN1= %b, IN2= %b, IN3= %b\n",IN0,IN1,IN2,IN3);
		// choose IN0
		S1 = 0; S0 = 0;
		#1 $display("S1 = %b, S0 = %b, OUTPUT = %b \n", S1, S0, OUTPUT);
		// choose IN1
		S1 = 0; S0 = 1;
		#1 $display("S1 = %b, S0 = %b, OUTPUT = %b \n", S1, S0, OUTPUT);
		// choose IN2
		S1 = 1; S0 = 0;
		#1 $display("S1 = %b, S0 = %b, OUTPUT = %b \n", S1, S0, OUTPUT);
		// choose IN3
		S1 = 1; S0 = 1;
		#1 $display("S1 = %b, S0 = %b, OUTPUT = %b \n", S1, S0, OUTPUT);
	end
	
endmodule


// Module 4-to-1 multiplexer. Port list is taken exactly from
// the I/O diagram.
module mux4_to_1 (out, i0, i1, i2, i3, s1, s0);
	
	// Port declarations from the I/O diagram
	output out;
	input i0, i1, i2, i3;
	input s1, s0;

	reg tempout;
	
	always @(s0,s1,i0,i1,i2,i3)
	begin	
	
	if (s1==1'b0 && s0==1'b0)
		tempout = i0;
	else if (s1==1'b0 && s0==1'b1)
		tempout = i1;
	else if (s1==1'b1 && s0==1'b0)
		tempout = i2;
	else
		tempout = i3;

	end	
	
	assign out=tempout;
	
endmodule
