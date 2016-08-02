x = [1, 2, 4, 6, 8, 10];
y = [3, 3, 4, 6, 7, 8];

plot(x,y);
grid on;

p1 = polyfit(x,y,1);
p1
p2 = polyfit(x,y,2);
x = -3:.0001:3;
figure;
plot(x, polyval(p1,x));
grid on;
figure;
plot(x, polyval(p2,x));
grid on;