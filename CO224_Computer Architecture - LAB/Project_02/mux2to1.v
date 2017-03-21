
// Define the 2 to 1 mux
module mux2_to_1 (out, i0, i1, s0);
	
	// Declare the outputs
	output out;
	
	//Declare the inputs
	input i0, i1;
	input s0;

	// tempout register for use in always block
	reg tempout;
	
	always @(s0,i0,i1)
	begin	
		
		if (s0==1'b0)
			tempout = i0;
		else if (s0==1'b1)
			tempout = i1;
		
		end	
	
	assign out=tempout;
	
endmodule
