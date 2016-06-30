#include "bigint.h"
#include <stdlib.h>
#include <string.h>


/* implement the functions in *.h 
 * Given are broken code!!!!!!!
 */ 

bigint_t temp;

bigint_t new_bigint(char * a) {
	temp = (bigint_t) malloc(sizeof(char)*100);
	int count = strlen(a);
	//printf("count : %d\n", count);
	int i,j;
	for ( i =count - 1,j=0; j<count; --i,j++)	{
		char ch = a[i];
		temp[j] = ch;
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

	temp[count] = '\0';
	//show_bigint(temp);
	// printf("%d\n", temp[0]);
	return temp;
}


int add(bigint_t sum, bigint_t a, bigint_t b)
{
	int count_b;
	for (count_b = 0; b[count_b] != '\0'; ++count_b); //Check the element count of bigint_t b
	
	count_b--;

	int count_a;
	for (count_a = 0; a[count_a] != '\0'; ++count_a); //Check the element count of bigint_t a
	
	count_a--;

	int count;
	if (count_a<count_b)	{		//Check what bigint_t is large
		count = count_b;
		int k;
		for (k = count_a+1; k <= count_b; ++k)	{	//Make smaller bigint's other elements to zero 
			a[k] = '0';
		}


	}else if(count_a > count_b){
		count = count_a;
		int k;
		for (k = count_b+1; k <= count_a; ++k)	{	//Make smaller bigint's other elements to zero 
			b[k] = '0';
		}
	} else{
		count = count_b;
		
	}
	int i;
	int carry = 0;
	for (i = 0; i <= count; ++i)	{
		//printf("%c ----- %c\n", a[i],b[i]);
		int s = getIntValue(a[i]) + getIntValue(b[i]) + carry;
		carry = (s >= 10) ? s/10 : 0;

		sum[i] = getCharValue(s%10);

		//printf("%d %d\n", s,carry);
	}

	if (carry != 0)
	{
		//char *ch = itoa(carry,ch,10);
	//	printf("%c\n",ch );
		sum[i] = getCharValue(carry);
		sum[i+1] = '\0';
	}else{
		
		sum[i] = '\0';

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
	for (i = 0; v[i] != '\0'; ++i);
	
	i--;
	for (; i>=0; --i)	{
		printf("%c", v[i]);
		
	}
}
 
char getCharValue(int val){
	switch(val){
		case 0:
			return '0';
			break;
		case 1:
			return '1';
			break;
		case 2:
			return '2';
			break;
		case 3:
			return '3';
			break;
		case 4:
			return '4';
			break;
		case 5:
			return '5';
			break;
		case 6:
			return '6';
			break;
		case 7:
			return '7';
			break;
		case 8:
			return '8';
			break;
		case 9:
			return '9';
			break;
		
	}
	return '\0';

} 

int getIntValue(char val){
	switch(val){
		case '0':
			return 0;
			break;
		case '1':
			return 1;
			break;
		case '2':
			return 2;
			break;
		case '3':
			return 3;
			break;
		case '4':
			return 4;
			break;
		case '5':
			return 5;
			break;
		case '6':
			return 6;
			break;
		case '7':
			return 7;
			break;
		case '8':
			return 8;
			break;
		case '9':
			return 9;
			break;
		
	}
	return -1;

} 
