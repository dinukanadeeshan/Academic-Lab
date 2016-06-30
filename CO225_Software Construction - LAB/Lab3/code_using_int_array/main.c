#include "bigint.h"
#include <stdio.h>
#include <assert.h>
#include <stdlib.h>

int main()
{
  
  // bigint_t a = new_bigint("1234");
  // bigint_t b = new_bigint("74");

  // bigint_t x = new_bigint("0");
  
  // add(x,a,b);

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
//}
  //==============================================================================
  return 0; 
}
  
  
