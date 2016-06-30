#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>


int main(int argc, char **argv){
	int val;
	switch(argv[1][1]){
		case 'H':
			switch(argv[2][1]){
				case 'B':
					
					hexaToBinary(argv[3]);
					break;
				case 'I':
					val  = hexaToInt(argv[3]);
					printf("%d\n",val);
					break;
				case 'F':
					hexaToFloat(argv[3]);
					break;
				case 'H':
					printf("0x%s\n",argv[3]);
					break;
				default:
				printf("Usage: ./binconvert -<input format> -<output format> <input>");
			}
			
			break;
		case 'B':
			switch(argv[2][1]){
				case 'H':
					binaryToHexa(argv[3]);
					break;
				case 'I':
					
					val = binaryToInt(argv[3]);
					printf("%d\n",val);
					break;
				case 'F':
					binaryToFloat(argv[3]);
					break;
				case 'B':
					printf("%s\n",argv[3]);
					break;
				default:
				printf("Usage: ./binconvert -<input format> -<output format> <input>");
			}
			break;
		case 'I':
			switch(argv[2][1]){
				case 'B':
					intToBinaryC(argv[3]);
					break;
				case 'H':
					intToHexa(argv[3]);
					break;
				case 'F':
					intToFloat(argv[3]);
					break;
					
				case 'I':
					printf("%s\n",argv[3]);
					break;
				default:
				printf("Usage: ./binconvert -<input format> -<output format> <input>");	
			}
			break;
		case 'F':
			switch(argv[2][1]){
				case 'F':
					printf("%s\n",argv[3]);
					break;
				case 'B':
					floatToBinary(argv[3]);
					break;
				case 'I':
					floatToInt(argv[3]);
					break;
				case 'H':
					floatToHexa(argv[3]);
					break;
				default:
				printf("Usage: ./binconvert -<input format> -<output format> <input>");
				
			}
			break;
			default:
				printf("Usage: ./binconvert -<input format> -<output format> <input>");
	}

	return 0;
}

void binaryToHexa(char *r){
	printf("0x");
	int i;
	for(i = 0;i<=31;){
		char a[] = {r[i],r[i+1],r[i+2],r[i+3],'\0'};
		
		if(strcmp(a,"0000") == 0){
				printf("0");
		} else if(strcmp(a,"0001") == 0){
				printf("1");
		} else if(strcmp(a,"0010") == 0){
				printf("2");
		} else if(strcmp(a,"0011") == 0){
				printf("3");
		} else if(strcmp(a,"0100") == 0){
				printf("4");
		} else if(strcmp(a,"0101") == 0){
				printf("5");
		} else if(strcmp(a,"0110") == 0){
				printf("6");
		} else if(strcmp(a,"0111") == 0){
				printf("7");
		} else if(strcmp(a,"1000") == 0){
				printf("8");
		} else if(strcmp(a,"1001") == 0){
				printf("9");
		} else if(strcmp(a,"1010") == 0){
				printf("A");
		} else if(strcmp(a,"1011") == 0){
				printf("B");
		} else if(strcmp(a,"1100") == 0){
				printf("C");
		} else if(strcmp(a,"1101") == 0){
				printf("D");
		} else if(strcmp(a,"1110") == 0){
				printf("E");
		} else if(strcmp(a,"1111") == 0){
				printf("F");
		}
			
		i+=4;
	}
	printf("\n");
}

int binaryToInt(char *r){
	if(r[0] == '0'){
		int i;
		int val = 0;
		int j=0;
		for(i = 31;i>=0;i--){
			if(r[i] == '1'){
				val += pow(2,j);
				
			}
			j++;
		}
		//printf("%d\n",val);
		return val;
	} else {
		int i;
		
		if(r[31] == '0'){
		
			for(i=30;i>=0;i++){
				if(r[i] == '1'){
					r[i] = '0';
					break;
				}else{
					r[i] = '1';
					continue;
				}
			}
			r[31]='1';
		} else {
			r[31]='0';
		
		}
		
		// invert of 1s compliment
		for(i=0;i<32;i++){
			if(r[i] == '1'){	
				r[i] = '0';
			}else if(r[i] == '0'){
				r[i] = '1';
			}
		}
		int j=0;
		int val = 0;
		for(i = 31;i>=0;i--){
			if(r[i] == '1'){
				val += pow(2,j);
				
			}
			j++;
		}
		return -val;
	}
}

void binaryToFloat(char *r){
	float f = binaryToInt(r);
	printf("%.02f\n",f);
}

void hexaToBinary(char *r){
	
	
	
	int i;
	for(i=0;i<=7;i++){
		switch(r[i]){
			case '0':
				printf("0000");
				break;
				
			case '1':
				printf("0001");
				break;
				
			case '2':
				printf("0010");
				break;
				
			case '3':
				printf("0011");
				break;
				
			case '4':
				printf("0100");
				break;
				
			case '5':
				printf("0101");
				break;
				
			case '6':
				printf("0110");
				break;
				
			case '7':
				printf("0111");
				break;
				
			case '8':
				printf("1000");
				break;
				
			case '9':
				printf("1001");
				break;
				
			case 'A':
				printf("1010");
				break;
				
			case 'B':
				printf("1011");
				break;
				
			case 'C':
				printf("1100");
				break;
				
			case 'D':
				printf("1101");
				break;
				
			case 'E':
				printf("1110");
				break;
				
			case 'F':
				printf("1111");
				break;
				
		}
		
	}
	printf("\n");
}

int hexaToInt(char *r){
	int i;
	int val = 0;
	int j=0;
	for(i = 7;i>=0;i--){
		
		switch(r[i]){
			case '0':
				
				break;
				
			case '1':
				val += 1 * pow(16,j);
				break;
				
			case '2':
				val += 2 * pow(16,j);
				break;
				
			case '3':
				val += 3 * pow(16,j);
				break;
				
			case '4':
				val += 4 * pow(16,j);
				break;
				
			case '5':
				val += 5 * pow(16,j);
				break;
				
			case '6':
				val += 6 * pow(16,j);
				break;
				
			case '7':
				val += 7 * pow(16,j);
				break;
				
			case '8':
				val += 8 * pow(16,j);
				break;
				
			case '9':
				val += 9 * pow(16,j);
				break;
				
			case 'A':
				val += 10* pow(16,j);
				break;
				
			case 'B':
				val += 11 * pow(16,j);
				break;
				
			case 'C':
				val += 12 * pow(16,j);
				break;
				
			case 'D':
				val += 13 * pow(16,j);
				break;
				
			case 'E':
				val += 14 * pow(16,j);
				break;
				
			case 'F':
				val += 15 * pow(16,j);
				break;
				
		}
		
		
		
		j++;
	}
	//printf("%d\n",val);
	return val;
}

void hexaToFloat(char *r){
	
	float f= hexaToInt(r);
	printf("%.02f\n",f);
	
}

void intToHexa(char *r){
	// first convert as binary
	int num = atoi(r);
	char ar[32];
	int i;
	for(i=0;i<32;i++){
		ar[i] = '0';
	}
	ar[32] = '\0';
	if(num >= 0){
		int temp = num;
		
		int j = 31;
		while(temp > 0){
			
			int rem = temp % 2;
			temp /= 2;
			
			
			if(rem == 1){
				ar[j] = '1';
			}
		
			
			j--;
		}
		
		
	
	}else {
		int temp = -num;
		
		int j = 31;
		while(temp > 0){
			
			int rem = temp % 2;
			temp /= 2;
			
			
			if(rem == 1){
				ar[j] = '1';
			}
		
			
			j--;
		}
		//printf("%s\n",ar);
		for(i=0;i<32;i++){
			if(ar[i] == '1'){	
				ar[i] = '0';
			}else if(ar[i] == '0'){
				ar[i] = '1';
			}
		}
		//printf("%s\n",ar);
		int xr;
		if(ar[31] == '0'){
			xr = 1;
		}else{
			xr = 2;
		}
	
		int carry = 0;
		if(xr == 2){
			carry = 1;
			ar[31] = '0';
		} else{
			carry = 0;
			ar[31] = '1';
		}
		//printf("%s\n",ar);
		//carry = 0;
		for(i=30;i>=0;i--){
			char c = ar[i];	
				int x;
				if(c == '0' && carry== 0 ){
					break;
				}
				if(ar[i] == '0'){
					x = carry;
				}else{
					x = 1 + carry;
				}
				if(x == 2){
					carry = 1;
					ar[i] = '0';
				} else{
					carry = 0;
					ar[i] = '1';
				}
			
		}
		ar[32] = '\0';
	
	
	}
	//end of the binary converting
	
	binaryToHexa(&ar);
}

void intToBinaryC(char *r){
	int num = atoi(r);
	if(num >= 0){
		int temp = num;
		char ar[32];
		int i;
		for(i=0;i<32;i++){
			ar[i] = '0';
		}
		ar[32] = '\0';
		int j = 31;
		while(temp > 0){
			
			int rem = temp % 2;
			temp /= 2;
			
			
			if(rem == 1){
				ar[j] = '1';
			}
		
			
			j--;
		}
		
		printf("%s\n",ar);
	
	}else {
		int temp = -num;
		char ar[32];
		int i;
		for(i=0;i<32;i++){
			ar[i] = '0';
		}
		ar[32] = '\0';
		int j = 31;
		while(temp > 0){
			
			int rem = temp % 2;
			temp /= 2;
			
			
			if(rem == 1){
				ar[j] = '1';
			}
		
			
			j--;
		}
		//printf("%s\n",ar);
		for(i=0;i<32;i++){
			if(ar[i] == '1'){	
				ar[i] = '0';
			}else if(ar[i] == '0'){
				ar[i] = '1';
			}
		}
		//printf("%s\n",ar);
		int xr;
		if(ar[31] == '0'){
			xr = 1;
		}else{
			xr = 2;
		}
	
		int carry = 0;
		if(xr == 2){
			carry = 1;
			ar[31] = '0';
		} else{
			carry = 0;
			ar[31] = '1';
		}
		//printf("%s\n",ar);
		//carry = 0;
		for(i=30;i>=0;i--){
			char c = ar[i];	
				int x;
				if(c == '0' && carry== 0 ){
					break;
				}
				if(ar[i] == '0'){
					x = carry;
				}else{
					x = 1 + carry;
				}
				if(x == 2){
					carry = 1;
					ar[i] = '0';
				} else{
					carry = 0;
					ar[i] = '1';
				}
			
		}
		ar[32] = '\0';
		printf("%s\n",ar);
	
	}
	
}

void intToBinary(int temp){
	
	char ar[32];
	int i;
	for(i=0;i<32;i++){
		ar[i] = '0';
	}
	ar[32] = '\0';
	int j = 31;
	while(temp > 0){
		
		int rem = temp % 2;
		temp /= 2;
		
		if(rem == 1){
			ar[j] = '1';
		}
		
		
		j--;
	}
	
	printf("%s\n",ar);
	
}

void intToFloat(char *r){
	float f = atoi(r);
	printf("%.02f\n",f);
}

void floatToBinary(char *r){
	//~ float f = atof(r);
	//~ 
	//~ int x = (int) f;
	//~ 
	//~ float fo = f - x;
	//~ 
	//~ //convert integer val to binary
	//~ char *ar = {'\0'};
	//~ 
	//~ int temp = x;
	//~ while(temp > 0){
		//~ 
		//~ int rem = temp % 2;
		//~ temp /= 2;
		//~ 
		//~ 
		//~ 
		//~ if(rem == 1){
			//~ ar = strcat("1",ar);
		//~ }else{
			//~ ar = strcat("0",ar);
		//~ }
		//~ 
		//~ 
		//~ 
	//~ }
	//~ //end
	//~ //convert decimal val to binary
	//~ while(fo){
		//~ 
	//~ }
	
	
}

void floatToHexa(char *r){
	float f = atof(r);
	
}

void floatToInt(char *r){
	
	float f = atof(r);
	int d = (int)f;
	printf("%d\n",d);
	
}

