function [avg] = average_2(A)
    [m,n] = size(A);
    avg = zeros(1,n);
    j=1;
    while j<=n
        tot = 0;
        for i=1:m
            tot = tot + A(i,j);
        end
        avg(j) = tot/m;
        j = j+1;
    end