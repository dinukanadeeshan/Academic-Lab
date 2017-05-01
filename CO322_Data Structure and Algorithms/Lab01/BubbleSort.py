
def bubble_sort(_list):
    i = 0;
    while i<len(_list):
        j=0;
        while j < len(_list) - i - 1:
            if _list[j]>_list[j+1] :
                tmp = _list[j+1];
                _list[j+1] = _list[j];
                _list[j] = tmp;
            j += 1;
        i += 1;

