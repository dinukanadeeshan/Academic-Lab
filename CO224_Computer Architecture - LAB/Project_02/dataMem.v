// This is the data memory
 module dataMemory(addr, writeData, memRead, memWrite, readData, clk);
	
	// Deaclare the inputs and outputs
	input [15:0] addr, writeData, memRead, memWrite, clk;
	output [15:0] readData;
	
	// 2D data memory register array to store data
	reg [1023:0] dataMem [15:0];
	
	// This is temporary out register that have to use in always block
	reg [15:0] tempRead;

	always @(posedge clk) 
	begin 
		if (memRead == 1'b1)	// Data read instruction 
		begin
			tempRead = dataMem[addr];	// Data value stored in temporary register
		end		
		
		if (memWrite == 1'b1)	// Data write instruction
		begin
			dataMem[addr] = writeData;	// Input data is written in data memory
		end
	end
	
	// Assign register value in tempRead for output 
	assign tempRead = memRead;
	
 endmodule
 