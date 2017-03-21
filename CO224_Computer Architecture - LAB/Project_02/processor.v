module pc(Aaddr, clk, Baddr);

	input [15:0] Aaddr;
	output [15:0] Baddr;
	reg [15:0] temp;
	
	always @(posedge clk)
	begin
		temp = Aaddr;
	end
	
	assign Baddr = temp;

endmodule
=======================================================================================================================
// This is the instruction memory
 module instruction_memory(addr, clk, instruction);
	// Declare the inputs, this is fucntional in clk cycle
	input [15:0] addr;
	input clk;
	
	// Declare the output instruction with 16 bits
	output [15:0] instruction;
 
	// Two-D instruction list registers for keep the instructions
	reg [100:0] instructionList [15:0];
	
	// This is temporary out register that have to use in always block
	reg [15:0] out;
	
	always @(posedge clk) begin				------------------------------------------------------------
		out = instructionList[addr];	// Read values for out register in instrucition list
	end
	
	// Assign register value in out for output 
	assign instruction = out;
 
 endmodule
 =============================================================================================================
// Define the 2 to 1 mux
module mux_instruction(Cadder, i0, i1, regDst);
	
	// Declare the outputs
	output Cadder;
	
	//Declare the inputs
	input i0, i1;
	input regDst;

	// tempout register for use in always block
	reg tempout;
	
	always @(regDst,i0,i1)
	begin	
		
		if (regDst == 1'b0)
			tempout = i0;
		else if (regDst == 1'b1)
			tempout = i1;
		
		end	
	
	assign Cadder = tempout;
	
endmodule
==========================================================================================================
module control(instruction, regWrite, aluCon, branch, memWrite, memRead, AluSrc, memToReg, regDst);

	input [3:0] instruction;	// Declare instruction as 4 bit input
	output regWrite, branch, memWrite, memRead, AluSrc, memToReg, regDst;	//Declare the outputs control signals 
	output [2:0] aluCon;	// ALU control 3 bit output declaration
	
	reg [2:0] temp_alu;	//Create temp registers for use in always block
	reg tempBranch,tempMemWrite, tempMemRead, tempAluSrc, tempMemToReg, tempRegDst; //Create temp registers for use in always block
	
	always @(instruction)	
	begin
		if (instruction == 4'b0010) // Check for instrucion op code is to ADD operation
		begin
			tempAluSrc = 1'b0;
			temp_alu = 3'b010;
			tempMemToReg = 1'b0;
			tempBranch = 1'b0;
			tempMemRead = 1'b0;
			tempMemWrite = 1'b0;
			tempRegDst = 1'b1;
			
		end
		
		if (instruction == 4'b0110)	// Check for instrucion op code is to SUB operation
		begin
			tempAluSrc = 1'b0;
			temp_alu = 3'b110;
			tempMemToReg = 1'b0;
			tempMemRead = 1'b0;
			tempBranch = 1'b0;
			tempMemWrite = 1'b0;
			tempRegDst = 1'b1;
		end
		
		if (instruction == 4'b0000) // Check for instrucion op code is to AND operation 
		begin
			temp_alu = 3'b000;
			tempBranch = 1'b0;
			tempMemRead = 1'b0;
			tempMemToReg = 1'b0;
			tempAluSrc = 1'b0;
			tempMemWrite = 1'b0;
			tempRegDst = 1'b1;
		end
		
		if (instruction == 4'b0001) // Check for instrucion op code is to OR operation
		begin
			temp_alu = 3'b001;
			tempMemRead = 1'b0;
			tempBranch = 1'b0;
			tempMemToReg = 1'b0;
			tempAluSrc = 1'b0;
			tempMemWrite = 1'b0;
			tempRegDst = 1'b1;
		end
		
		if (instruction == 4'b0111) // Check for instrucion op code is to SLT operation
		begin
			temp_alu = 3'b111;
			tempBranch = 1'b0;
			tempMemToReg = 1'b0;
			tempMemRead = 1'b0;
			tempAluSrc = 1'b0;
			tempMemWrite = 1'b0;
			tempRegDst = 1'b0;
		end
		
		if (instruction == 4'b1000) // Check for instrucion op code is to LW operation
		begin
		
			tempBranch = 1'b1;
			tempMemWrite = 1'b0;
			tempMemToReg = 1'b1;
			tempMemRead = 1'b1;
			tempAluSrc = 1'b1;
			temp_alu = 3'b010;
			tempRegDst = 1'b0;
		end
		
		if (instruction == 4'b1010) // Check for instrucion op code is to SW operation
		begin
			tempBranch = 1'b1;
			tempMemWrite = 1'b1;
			tempMemRead = 1'b0;
			tempMemToReg = 1'b0;
			tempAluSrc = 1'b1;
			temp_alu = 3'b010;
			tempRegDst = 1'b0;
		end
		
		if (instruction == 4'b1110) // Check for instrucion op code is to BNE operation
		begin
			temp_alu = 3'b011;
			tempBranch = 1'b1;
			tempMemWrite = 1'b0;
			tempMemToReg = 1'b0;
			tempAluSrc = 1'b1;
			tempMemRead = 1'b0;
			temp_alu = 3'b010;
			tempRegDst = 1'b0;
		end
		
		if (instruction == 4'b1111) // Check for instrucion op code is to Jump operation
		begin
			tempBranch = 1'b0;
			tempMemWrite = 1'b0;
			tempMemToReg = 1'b0;
			tempMemRead = 1'b0;
			tempAluSrc = 1'b1;
			temp_alu = 3'b010;
			tempRegDst = 1'b0;
		end
	end

	// Assign the register values for outputs
	assign aluCon = temp_alu;
	assign branch = tempBranch;
	assign memWrite = tempMemWrite;
	assign memRead = tempMemRead;
	assign AluSrc = tempAluSrc;
	assign memToReg = tempMemToReg;
	assign regDst = tempRegDst;
	
endmodule
========================================================================================================