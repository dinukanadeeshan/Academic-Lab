module stimulus_for;

integer count;

initial
begin
	count = 0;
	for(count=0;count<128;count=count+1)
	begin
		$display("Count = %d",count);
	end

end

endmodule