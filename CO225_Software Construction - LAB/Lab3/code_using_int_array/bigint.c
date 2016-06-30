#include "bigint.h"
#include <stdlib.h>
#include <string.h>


/* implement the functions in *.h 
 * Given are broken code!!!!!!!
 */ 

bigint_t temp;

bigint_t new_bigint(char * a) 
{
	temp = (bigint_t) malloc(sizeof(int)*100);
	int count = strlen(a);
	//printf("count : %d\n", count);
	int i,j;
	for ( i =count - 1,j=0; j<count; --i,j++)	{
		char ch = a[i];
		temp[j] = atoi(&ch);
		//printf("%d\n", temp[j]);
	}

	// int i=0;
	// while(a > 0){
	// 	//printf("Entered...\n");
	// 	temp[i] = a%10;
	// 	//printf("%d\n", a);
	// 	a /= 10;
		
		

	// 	i++;
	// }

	temp[count] = -1;
	//show_bigint(temp);
	// printf("%d\n", temp[0]);
	return temp;
}


int add(bigint_t sum, bigint_t a, bigint_t b)
{
	int count_b;
	for (count_b = 0; b[count_b] != -1; ++count_b); //Check the element count of bigint_t b
	
	count_b--;

	int count_a;
	for (count_a = 0; a[count_a] != -1; ++count_a); //Check the element count of bigint_t a
	
	count_a--;

	int count;
	if (count_a<count_b)	{		//Check what bigint_t is large
		count = count_b;
		int k;
		for (k = count_a+1; k <= count_b; ++k)	{	//Make smaller bigint's other elements to zero 
			a[k] = 0;
		}


	}else if(count_a > count_b){
		count = count_a;
		int k;
		for (k = count_b+1; k <= count_a; ++k)	{	//Make smaller bigint's other elements to zero 
			b[k] = 0;
		}
	} else{
		count = count_b;
		
	}
	int i;
	int carry = 0;
	for (i = 0; i <= count; ++i)	{
		int s = a[i] + b[i] + carry;
		carry = (s >= 10) ? s/10 : 0;
		sum[i] = s%10;
		//printf("%d %d\n", s,carry);
	}

	if (carry != 0)
	{
		sum[i] = carry;
		sum[i+1] = -1;
	}else{
		
		sum[i] = -1;

	}
	//printf("End here\n" );
	return 0;
}

void free_bigint(bigint_t t){
	free(t);
}

void show_bigint(bigint_t v) 
{	
	//printf("%d\n", *v);
	int i;
	for (i = 0; v[i] != -1; ++i);
	
	i--;
	for (; i>=0; --i)	{
		printf("%d", v[i]);
		
	}
}
  
