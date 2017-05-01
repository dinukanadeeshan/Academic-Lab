
def selection_sort(_list):
    i = len(_list)-1;
    while i >= 0:
        j=0;
        max = _list[0];
        index  = 0;
        while j < i+1:
            if max < _list[j]:
                index = j;
                max = _list[j];


            j+=1;

        tmp = _list[i];
        _list[i] = _list[index];
        _list[index] = tmp;
       # print(_list , " " , i);
        i -= 1;
