//Lab 8 : 4-bit Counter implementation in verilog

// Top level stimulus module
module testbed;

	// Declare variables for stimulating input
	reg CLK, CLEAR_BAR;
	wire [3:0] NUM;
	
	initial
		$monitor($time," Count : %d",NUM);
		
	//Instantiate the design block counter	
	//NUM is the 4-bit output from the counter
	//CLK is the clock signal
	//The counter should increment at each falling edge of the clock cycle 
	//CLEAR_BAR is the signal that asynchronously clears the counter. A CLEAR_BAR=0 should clear the counter.
	rippleCounter4 mycounter(NUM,CLK,CLEAR_BAR);	
		
	// reset	
	initial
	begin	
		CLEAR_BAR=1'b0;	
		#5 CLEAR_BAR=1'b1;
		#500 CLEAR_BAR=1'b0;
		#50 CLEAR_BAR=1'b1;
	end		
		
	// Set up the clock to toggle every 10 time units	
	initial
	begin
		
		//generate files needed to plot the waveform
		//you can plot the waveform generated after running the simulator by using gtkwave	
		$dumpfile("wavedata.vcd");
		$dumpvars(0,testbed);	
		CLK = 1'b0;
		forever #10 CLK = ~CLK;
		
		
	end

	// Finish the simulation at time 400
	initial
	begin
		#700 $finish;
	end
	
endmodule


//you code goes here

module rippleCounter4(NUM,CLK,CLEAR_BAR);
	output [3:0] NUM;
	input CLK, CLEAR_BAR;
	
	t_flipflop t_flipflop1(NUM[0],1'b1,CLK,CLEAR_BAR);
	t_flipflop t_flipflop2(NUM[1],1'b1,NUM[0],CLEAR_BAR);
	t_flipflop t_flipflop3(NUM[2],1'b1,NUM[1],CLEAR_BAR);
	t_flipflop t_flipflop4(NUM[3],1'b1,NUM[2],CLEAR_BAR);
	
	
endmodule


module s_r_latch(Q,S,R,R2);
	output Q;
	input S,R,R2;
	wire _Q;
	
	nand (Q,S,_Q);
	nand (_Q,R,Q,R2);
	
endmodule 


module d_latch(Q,D,En,R2);
	output Q;
	input D,En,R2;
	
	wire _D,s1,s2;
	
	not(_D,D);
	
	nand(s1,D,En);
	nand(s2,_D,En);
	
	s_r_latch mysrlatch(Q,s1,s2,R2);
	
endmodule


module d_flipflop(Q,D,CLK,R2);
	input D,CLK,R2;
	output Q;
	
	wire _CLK,Y;
	not(_CLK,CLK);
	
	d_latch master(Y,D,_CLK,R2);
	
	d_latch slave(Q,Y,CLK,R2);
endmodule


module t_flipflop(Q,T,CLK,R2);
	input T,CLK,R2;
	output Q;
	wire D,_CLK;
	xor(D,Q,T);
	not(_CLK,CLK);
	
	d_flipflop myDflipflop(Q,D,_CLK,R2);
	
endmodule
