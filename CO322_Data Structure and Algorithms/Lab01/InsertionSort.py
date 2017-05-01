
def insertion_sort(_list):
    i = 1;
    while i < len(_list):
        tmp = _list[i];
        j=i-1;
        while j >= 0:
            if _list[j] > tmp:
                _list[j+1] = _list[j]
                _list[j] = tmp
            j -= 1;
        i+=1;

