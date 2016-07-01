r = 1.5;
x = 51;
for i=1:100
     n_r = (r + (x/r))*0.5;
     if n_r == r 
         %disp('break');
         break;
     end
     r = n_r;
end

fprintf('%f\n',r);