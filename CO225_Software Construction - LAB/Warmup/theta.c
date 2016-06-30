/**
* Author 	: Mohammed Fawzan
* Problem 	: Guilty
*/

/**
*	I need a chunk of string for given size,
*	Am I making a mistake?  You tell me. 
*/
#include <stdlib.h>


char * giveMeSomeMemory ( int size );

int main(){
	char * ch = giveMeSomeMemory(10);
	ch[0] = 'A';
	return 0;
}

char * giveMeSomeMemory ( int size ){
	static char * str ;
	if (size > 0)
		str =( char *) malloc ( sizeof(char)*size );
	else
		return NULL ;
	return ( str );
}
