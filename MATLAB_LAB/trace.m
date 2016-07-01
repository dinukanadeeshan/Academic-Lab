function tot = trace(A)
    [m,n] = size(A);
    if m ~= n
        error('Invalid Matrix');
    end
    tot = 0;
    for i=1:m
       tot = tot + A(i,i);
    end
