/**
* Author 	: Mohammed Fawzan
* Problem 	: If Then Else
*/


#include <limits.h>
#include <stdio.h>

#define MAXINT INT_MAX

/**
*	Find the minimum vlue from a given integer array
* 	@param int* A 	pointeer to an integer array
*	@param int n 	number of elements in the array
*/
int getMin(int *Array, int n) {
  
  int currmin = MAXINT;
  int i;
  for (i=0; i<n; i++)
    if (Array[i] < currmin)
      currmin = Array[i];
  return currmin;

}

int main(){
	int arr[7] = {4, 5, 2,  5, 6, 2, 10};  
	int min = getMin(&arr, 7 );

	printf("Min is : %d\n", min);
	return 0;
}

