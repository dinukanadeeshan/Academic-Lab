 // Define the ALU module
 
 module alu(read1, read2, result,c_in, c_out, over_flow, clk, con);
	// Declare the inputs ports with specific bit size and clk
	input [2:0] con;
	input [15:0] read1, read2;
	input c_in;
	input clk;
	
	// Declare the result as output port in alu module
	output [15:0] result;
	output c_out,over_flow;
	
	
	// These are internal registers use as temp values to use in always block
	reg [15:0] tempout;
	reg over_flow_temp;
	
	
	always @(posedge clk) begin		// Make this fucntional in positive edge in clock cycle
		// Check where controller in ALU is for AND operation
		if (con == 3'b000)	//And
		begin
			tempout = read1 & read2;
			over_flow_temp = 0;
		end
		
		// Check where controller in ALU is for OR operation
		if (con == 3'b001)	//Or
		begin
			tempout = read1 | read2;
			over_flow_temp = 0;
		end
		
		// Check where controller in ALU is for ADD operation
		if (con == 3'b010) //Add
		begin
			{over_flow_temp,tempout} = read1 + read2 + c_in;
		end
		
		// Check where controller in ALU is for SUB / BNE operation
		if (con == 3'b011)	//sub bne
		begin
			tempout = c_in + read1 - read2;
			over_flow_temp = 0;
		end
		
		// Check where controller in ALU is for SLT operation
		if (con == 3'b111) //slt
		begin
			over_flow_temp = 0;
			tempout = 0;
		end
	end
	
	
	// Assign the tempout value to output wire
	assign result = tempout;
	assign over_flow = over_flow_temp;
	assign c_out = over_flow_temp;
 
 endmodule
 