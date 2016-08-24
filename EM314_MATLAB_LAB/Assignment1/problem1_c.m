 x_0 = 1;
  x_1 = x_0 - ((x_0 - 12 .* x_0 .^(1/3)  + 12)/(1 - 4 * x_0 .^ (-2/3))); 
c = 0;
while abs(x_0 - x_1) > eps
    x_0 = x_1;
    x_1 = x_0 - ((x_0 - 12 .* x_0 .^(1/3)  + 12)/(1 - 4 * x_0 .^ (-2/3))); 
    
    c = c + 1;
end

fprintf('%.8f for %d of iteration\n',x_1,c);