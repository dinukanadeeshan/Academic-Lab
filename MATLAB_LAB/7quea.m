r = 1.5;
x = 43;
for i=1:100
     n_r = r + (x/r);
     if n_r == r 
         break;
     end
     r = n_r;
end

fprintf('%f\n',r);