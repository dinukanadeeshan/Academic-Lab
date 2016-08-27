x = -10:0.000001:10;

y = feval(@prob1function, x);

%y = prob1function(x);
figure;
plot(x,y);
grid on;