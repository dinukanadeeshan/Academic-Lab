module register_file(C,Caddr, A,B, Aaddr,Baddr, load,clear,clk);
	// Declare the inputs with 4 bit addresses and data value in C with 16 bits and other control signals like load, clk and clear 
	input [3:0] Caddr, Aaddr, Baddr;	
	input [15:0] C;
	input load, clear, clk;
	
	
	// Declare the output points
	output [15:0] A, B;
	integer i;

	// This is two diamensional register file
	reg [15:0] regFile [15:0];

	// Use temporary registers for use in always block
	reg [15:0] tempA;
	reg [15:0] tempB;
	
	always @(posedge clk)	//Make this register file work for positive edge in clk cycle - Read from register file
	begin
		
		
		// Read data in register file to reg tempA and tempB when load is 1
		if(load)
		begin
			tempA = regFile[Aaddr];
			tempB = regFile[Baddr];
		end
	
	end
	
	always @(clear) begin
		// check whether the clear == 0 and clear the register file
		if(clear == 1'b0) 
		begin		
				for(i=0;i<16;i=i+1)
				begin
					regFile [i] = 16'd0;
				
				end
		end
	end 
	
	always @(negedge clk) begin	//Make this register file work for negetive edge in clk cycle - Write to register file
		
		// If load is equals to 1 then write data to register file in specific location
		if(load)
		begin
			regFile[Caddr] = C;
		end
	
	end

	
	// Assign register values to outputs
	assign A = tempA;
	assign B = tempB;

	
endmodule
