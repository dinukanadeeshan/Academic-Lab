// This is the instruction memory
 module instruction_memory(addr,clk ,instruction);
	// Declare the inputs, this is fucntional in clk cycle
	input [15:0] addr;
	input clk;
	
	// Declare the output instruction with 16 bits
	output [15:0] instruction;
 
	// Two-D instruction list registers for keep the instructions
	reg [100:0] instructionList [15:0];
	
	//This is temporary out register that have to use in always block
	reg [15:0] out;
	
	always @(posedge clk) begin
		out = instructionList[addr];	// read values for out register in instrucition list
	
	end
	
	// Assign register value in out for output 
	assign instruction = out;
 
 endmodule
 