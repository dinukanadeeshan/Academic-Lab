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