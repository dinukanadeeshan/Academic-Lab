function A = seqint(m,n)
    vec = 1:(m*n);
    %A = vec2mat(vec,n);
    A = reshape(vec,[m,n]);