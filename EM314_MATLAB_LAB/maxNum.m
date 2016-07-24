function max = maxNum(A)
    [m,n] = size(A);
    max = A(1);
    for i=1:n
        if max < A(i)
            max = A(i);
        end
    end