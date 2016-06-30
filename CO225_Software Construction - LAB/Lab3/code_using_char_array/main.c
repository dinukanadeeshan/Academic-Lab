#include "bigint.h"
#include <stdio.h>
#include <assert.h>
#include <stdlib.h>

int main()
{
  
  // bigint_t a = new_bigint("154634");
  // bigint_t b = new_bigint("7424");

  // bigint_t x = new_bigint("0");
  
  // //printf("hehe\n");
  // add(x,a,b);
  // // printf("%s\n", a);
  // // printf("%s\n", b);
  // // printf("%s\n", x);


  // show_bigint(x);

  


  //=============================================================================
  int i, f = 100; 
  //for(f = 1; f < 100; f++) {
    bigint_t a, b, fib; 
    a = new_bigint("1");
    b =  new_bigint("1");
    
    for(i=3; i < f; i++) { 
      fib =  new_bigint("0");
      
      add(fib,a,b); 
      a = b; 
      b = fib; 
      printf("%d the Fib is ", i);
      show_bigint(fib);
      printf("\n");

    }

  //} // end for(fib=10..)
  //==============================================================================
  return 0; 
}
  
  
