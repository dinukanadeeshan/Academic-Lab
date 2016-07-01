r = linspace(0,5,20);
theta = linspace(0,2*pi,20);

X = r.*cos(theta);
Y = r.*sin(theta);
[x,y] = meshgrid(X,Y);
Z=2 + x.^2 + y.^2;

 surf(x,y,Z);