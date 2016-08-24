x = -10:0.1:30;

y=x - 12 .* x .^(1/3)  + 12;

figure;
plot(x,y, 'b-');
grid on;
hold on;



