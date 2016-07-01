function [avg] = average(A)
    [m,n] = size(A);
    avg = zeros(m,1);
    j=1;
    while j<=m
        tot = 0;
        for i=1:n
            tot = tot + A(j,i);
        end
        avg(j) = tot/n;
        j = j+1;
    end