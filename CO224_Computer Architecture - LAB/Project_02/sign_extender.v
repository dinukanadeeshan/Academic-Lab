

module SignExtend(inAddr,outAddr);
	input [3:0]inAddr;
	output [15:0]outAddr;
	
	reg [3:0]temp1;
	reg [15:0] temp;
	
	always @(temp,inAddr) begin
		temp1 = inAddr & 4'b1000;
		if( temp1 == 4'b1000) begin		// when most significant bit is 1
			temp = {12'b111111111111,inAddr};
		end
		if( temp1 == 4'b0000) begin		// when most significant bit is 0
			temp = {12'b000000000000,inAddr};
		end
	end
	
	assign outAddr = temp;

endmodule
