module flipflop(D,clock,Q);

input D,clock;
output reg Q;

always @(posedge clock)
begin
	Q = D;
end

endmodule
