module blocking_nonblocking;

reg x, y, z;
reg [15:0] reg_a, reg_b;
integer count;

//All behavioral statements must be inside an initial or always block
initial
begin
	x = 0; y = 1; z = 1; //Scalar assignments
	count = 0; //Assignment to integer variables
	reg_a = 16'b0; reg_b = reg_a; //Initialize vectors

	reg_a[2] <= #15 1'b1; //Bit select assignment with delay
	reg_b[15:13] <= #10 {x, y, z}; //Assign result of concatenation to part select of a vector
	count <= count + 1; //Assignment to an integer (increment)
end
endmodule

/*
In this example, the statements x = 0 through reg_b = reg_a are executed sequentially at
time 0. Then the three nonblocking assignments are processed at the same simulation
time.
1. reg_a[2] = 0 is scheduled to execute after 15 units (i.e., time = 15)
2. reg_b[15:13] = {x, y, z} is scheduled to execute after 10 time units (i.e.,
time = 10)
3. count = count + 1 is scheduled to be executed without any delay (i.e., time = 0)
*/