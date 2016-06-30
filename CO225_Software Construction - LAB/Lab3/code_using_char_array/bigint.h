#ifndef _BIGINT_H
#define _BIGINT_H

#include <stdio.h>

/* change this code! */
typedef char * bigint_t; 
int getIntValue(char val);
char getCharValue(int val);
/**
 * Create a new bigint
 * the new integer should store the given int value
 * assume that given value is within the range of int
 */
bigint_t new_bigint(char * x);

/**
 * free all the memory used by the given bigint
 */
void free_bigint(bigint_t t); 

/**
 * add bigints a and b and store the results in sum
 * Assums: all 3 bigints are allocated before calling
 * return 0 if addition was successful 
 */
int add(bigint_t sum, bigint_t a, bigint_t b); 


/** 
 * Display the value of the given bigint
 */
void show_bigint(bigint_t v); 


#endif

