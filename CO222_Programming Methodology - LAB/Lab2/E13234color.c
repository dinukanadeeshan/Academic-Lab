#include<stdio.h>
#include<math.h>


int main(){
	
	int r,g,b;
	printf("Enter the color: ");
	scanf("%d %d %d", &r, &g, &b);			// Read color from user
	
	if( r < 0 || g < 0  || b < 0 || r > 255 || g > 255 || b > 255){
		printf("Enter valid input\n");
		return 0;
	}
	
	int comR, comG, comB;
	
	
	if(abs(r - 128) < 32){					// Check whether it is gray color
		if(r >= 128){
			comR = r - 128;
		}else{
			comR = r + 128;
		}
	}else{
		comR = 255 - r;
	}
	
	if(abs(g - 128) < 32){					// Check whether it is gray color
		if(g >= 128){
			comG = g - 128;
		}else{
			comG = g + 128;
		}
	}else{
		comG = 255 - g;
	}
	
	if(abs(b - 128) < 32){				// Check whether it is gray color
		if(b >= 128){
			comB = b - 128;
		}else{
			comB = b + 128;
		}
	}else{
		comB = 255 - b;
	}
	
	
	printf("The complement: %d %d %d\n", comR,comG,comB);		//output the result
	
	return 0;
}
