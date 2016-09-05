module simulate_register;

	reg [3:0] In;
	wire [3:0] Out;
	reg Enable, CLK, Select;
	
	
	shift_register_4_bit register(Enable,CLK,Select,In,Out);
	//assign Out = 4'b0000;
	initial
	begin
		CLK = 1'b0;
		Enable = 1'b1; Select = 1'b0;  In = 4'b1011; 
		#6 $display("%b\n",Out);
		In = Out;
		#5 $display("%b\n",Out);
		In = Out;
		#5 $display("%b\n",Out);
		In = Out;
		#5 $display("%b\n",Out);
		In = Out;
		#5 $display("%b\n",Out);
		In = Out;
		#5 $display("%b\n",Out);
		In = Out;
		#5 $display("%b\n",Out);
		#45 $finish;
	end
	always
	begin
		#5 CLK = ~CLK;
	end
	
endmodule

module shift_register_4_bit(ENABLE,CLK,SELECT,DATA_IN,DATA_OUT);

input  [3:0] DATA_IN;
input  CLK,ENABLE,SELECT;
output  [3:0] DATA_OUT;

reg [3:0] data_out_temp;

always @(posedge CLK)
begin
	if(ENABLE == 1'b1 && SELECT == 1'b0)
		data_out_temp = DATA_IN << 1;
		
	else if(ENABLE == 1'b1 && SELECT == 1'b1)
		data_out_temp = DATA_IN >> 1;
end

assign DATA_OUT = data_out_temp;
//assign DATA_IN = data_out_temp;

endmodule


