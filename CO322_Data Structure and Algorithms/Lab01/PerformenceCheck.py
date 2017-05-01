import random
from timeit import default_timer as timer
from BubbleSort import *
from SelectionSort import *
from InsertionSort import *

N = 1000
lst = []
for i in range(0, N):
    lst.append(random.randrange(-1000,1000))

print(lst)
print("===================================== Using Bubble Sort Algorithm =====================================\n")
lst1 = lst
time_start = timer()
bubble_sort(lst1)
time_end = timer()
print(lst1)
print("Time taken : ", (time_end - time_start), "s\n")

print("===================================== Using Selection Sort Algorithm =====================================\n")
lst2 = lst
time_start = timer()
selection_sort(lst2)
time_end = timer()
print(lst2)
print("Time taken : ", (time_end  - time_start), "s\n")

print("===================================== Using Insertion Sort Algorithm =====================================\n")
lst3 = lst
time_start = timer()
insertion_sort(lst3)
time_end = timer()
print(lst3)
print("Time taken : ", (time_end  - time_start), "s\n")
