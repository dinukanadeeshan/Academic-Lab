module testSimulate;

endmodule


module reg_file(C, Caddr, A, B, Aaddr, Baddr, load, clear, clk);

	input [3:0] Caddr, Aaddr, Baddr;
	input [15:0] C;
	input load, clear, clk;
	
	output [15:0] A, B;
	integer i;

	reg [15:0] regFile [15:0];

	reg [15:0] tempA;
	reg [15:0] tempB;
	
	always @(posedge clk)
	begin
		if(~clear)
		begin
			for(i=0;i<15;i = i+1)
			begin
				regFile[i] = 0;
			end
		end
		
		if(~load)
		begin
			regFile[Caddr] = C;
		end
		
		if(load)
		begin
			tempA = regFile[Aaddr];
			tempB = regFile[Baddr];
		end
	end

	assign A = tempA;
	assign B = tempB;

endmodule
