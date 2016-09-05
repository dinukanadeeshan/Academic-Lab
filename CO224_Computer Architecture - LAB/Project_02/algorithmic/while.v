module stimulus_while;

integer count;

initial
begin
	count = 0;
	while(count<128)
	begin
		count=count+1;
		$display("Count = %d",count);
	end

end

endmodule