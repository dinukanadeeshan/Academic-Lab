from timeit import default_timer as timer
from BubbleSort import *
from SelectionSort import *
from InsertionSort import *


def isEqual(lst1, lst2):
    if len(lst1) != len(lst2):
        return False
    for i in range(0,len(lst2)):
        if lst1[i] != lst2[i]:
            return False
    return True

def test(expected, actual):
    if isEqual(expected, actual):
        print("Testcase passed :=: Expected : ",expected, " | Actual : ", actual)
    else:
        print("Testcase failed :=: Expected : ", expected, " | Actual : ", actual)

lst = [];
print("List that sort to be : ", lst)

time_start = timer()
bubble_sort(lst)
time_end = timer()

test([],lst)
print("Bubble Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
selection_sort(lst)
time_end= timer()
test([],lst)
print("Selection Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
insertion_sort(lst)
time_end = timer()
test([],lst)
print("Insertion Sort,  It takes : ", (time_end - time_start))

lst = [10,5,6,9,7,15]
print("\n============================================================================\nList that sort to be : ", lst)

time_start = timer()
bubble_sort(lst)
time_end = timer()
test([5, 6, 7, 9, 10, 15],lst)
print("Bubble Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
selection_sort(lst)
time_end= timer()
test([5, 6, 7, 9, 10, 15],lst)
print("Selection Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
insertion_sort(lst)
time_end = timer()
test([5, 6, 7, 9, 10, 15],lst)
print("Insertion Sort,  It takes : ", (time_end - time_start))



lst = [5,5,5,5,5,5,5]
print("\n============================================================================\nList that sort to be : ", lst)

time_start = timer()
bubble_sort(lst)
time_end = timer()
test([5, 5, 5, 5, 5, 5, 5],lst)
print("Bubble Sort,  It takes : ", (time_end - time_start))

print("---------------")

time_start = timer()
selection_sort(lst)
time_end= timer()
test([5, 5, 5, 5, 5, 5, 5],lst)
print("Selection Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
insertion_sort(lst)
time_end = timer()
test([5, 5, 5, 5, 5, 5, 5],lst)
print("Insertion Sort,  It takes : ", (time_end - time_start))



lst = [-4,5,8,-5,-10,2]
print("\n============================================================================\nList that sort to be : ", lst)

time_start = timer()
bubble_sort(lst)
time_end = timer()
test([-10, -5, -4, 2, 5, 8],lst)
print("Bubble Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
selection_sort(lst)
time_end= timer()
test([-10, -5, -4, 2, 5, 8],lst)
print("Selection Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
insertion_sort(lst)
time_end = timer()
test([-10, -5, -4, 2, 5, 8],lst)
print("Insertion Sort,  It takes : ", (time_end - time_start))




lst = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
print("\n===================================== A best case =======================================\nList that sort to be : ", lst)

time_start = timer()
bubble_sort(lst)
time_end = timer()
test([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20],lst)
print("Bubble Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
selection_sort(lst)
time_end= timer()
test([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20],lst)
print("Selection Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
insertion_sort(lst)
time_end = timer()
test([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20],lst)
print("Insertion Sort,  It takes : ", (time_end - time_start))

lst = [20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1]
print("\n================================== A worst case ==========================================\nList that sort to be : ", lst)

time_start = timer()
bubble_sort(lst)
time_end = timer()
test([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20],lst)
print("Bubble Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
selection_sort(lst)
time_end= timer()
test([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20],lst)
print("Selection Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
insertion_sort(lst)
time_end = timer()
test([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20],lst)
print("Insertion Sort,  It takes : ", (time_end - time_start))



lst = [10,5,6,9,7,15,3,34,54,65,767,8,989,89,0,55,34,24,2,3456,567,89,89,0,6,56,45,63,44,576,78,789,
       78,780,78,657,456,34,53,54,75,86,78,678,56,345,345,345,3,89,865,3
       ,23,56,5,6,5,65,65,6535,6,4,56456,8,6,6,2,23,5,5,45,4,35,23,54,53,53,45,3,23,4512,2312,3,13,53,5,23,8,7,448,32,8,132,12,31,3,45,6,23,15]
print("\n============================================================================\nList that sort to be : ", lst,"\n")

time_start = timer()
bubble_sort(lst)
time_end = timer()
test([0, 0, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 10, 12, 13, 15, 15, 23, 23, 23, 23, 23, 23, 24, 31, 32, 34, 34, 34, 35, 44, 45, 45, 45, 45, 53, 53, 53, 53, 54, 54, 54, 55, 56, 56, 56, 63, 65, 65, 65, 75,
      78, 78, 78, 78, 86, 89, 89, 89, 89, 132, 345, 345, 345, 448, 456, 567, 576, 657, 678, 767, 780, 789, 865, 989, 2312, 3456, 4512, 6535, 56456],lst)
print("Bubble Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
selection_sort(lst)
time_end= timer()
test([0, 0, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 10, 12, 13, 15, 15, 23, 23, 23, 23, 23, 23, 24, 31, 32, 34, 34, 34, 35, 44, 45, 45, 45, 45, 53, 53, 53, 53, 54, 54, 54, 55, 56, 56, 56, 63, 65, 65, 65, 75,
      78, 78, 78, 78, 86, 89, 89, 89, 89, 132, 345, 345, 345, 448, 456, 567, 576, 657, 678, 767, 780, 789, 865, 989, 2312, 3456, 4512, 6535, 56456],lst)

print("Selection Sort,  It takes : ", (time_end - time_start))

print("---------------");

time_start = timer()
insertion_sort(lst)
time_end = timer()
test([0, 0, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 10, 12, 13, 15, 15, 23, 23, 23, 23, 23, 23, 24, 31, 32, 34, 34, 34, 35, 44, 45, 45, 45, 45, 53, 53, 53, 53, 54, 54, 54, 55, 56, 56, 56, 63, 65, 65, 65, 75,
      78, 78, 78, 78, 86, 89, 89, 89, 89, 132, 345, 345, 345, 448, 456, 567, 576, 657, 678, 767, 780, 789, 865, 989, 2312, 3456, 4512, 6535, 56456],lst)

print("Insertion Sort,  It takes : ", (time_end - time_start))


