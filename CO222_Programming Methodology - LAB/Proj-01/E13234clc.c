#include <stdio.h>

double doubleVal(char *input);
void binaryToHexa(char *input);
int binaryToInt(char *input);
void binaryToFloat(char *input);
void binaryToDouble(char *input);
void hexaToBinary(char *input);
void binaryToFloat(char *input);
int hexaToInt(char *input);
void hexaToFloat(char *input);
void hexaToDouble(char *input);
void intToHexa(char *input);
char * intToBinaryC(char *input);
void intToFloat(char *input);
//~ void intToDouble(char *input);
void floatToBinary(char *input);
void floatToHexa(char *input);
void floatToInt(char *input);
int countCharArray(char *arr);
int intVal(char *input);
char * intToBinaryC(char *input);
double powd(int a, int b);
int stringcompare(char *str1, char *str2);


int main(int argc, char **argv){
	/*
		Check the number of arguments.
	*/
	if (argc != 4)	{
		fprintf(stderr, "ERROR: The number of arguments is wrong.\nUsage: ./clc -<input format> -<output format> <input>\n");
		return 1;
	}

	/*
		Check the output format is Correct
	*/
	if (argv[2][1] != 'B' && argv[2][1] != 'D' && argv[2][1] != 'F' && argv[2][1] != 'I' && argv[2][1] != 'H')	{	
		fprintf(stderr, "ERROR: The output argument is wrong.\nPossible output arguments are -B, -H, -I, -F and -D.\n" );
		return 1;
	}

	int val;
	char *arr;			// An array for int to binary conversion
	int i,dotCount = 0;
	/*
		Switch the input argument
	*/
	switch(argv[1][1]){	
		case 'H':
			/*
				Check Hexadecimal input has valid size
			*/
			if (countCharArray(argv[3]) != 8 && countCharArray(argv[3]) != 16){
				fprintf(stderr, "ERROR: The input size is wrong.\n");
				return 1;
			}

			/*
				Switch the output arguments
			*/
			switch(argv[2][1]){
				case 'B':
					//~ if(countCharArray(argv[3]) > 8){
						//~ fprintf(stderr,"ERROR: This conversion is not possible.\n");
						//~ return 1;
					//~ }
					hexaToBinary(argv[3]);
					break;
				case 'I':
					if(countCharArray(argv[3]) > 8){
						fprintf(stderr,"ERROR: This conversion is not possible.\n");
						return 1;
					}
					val  = hexaToInt(argv[3]);
					fprintf(stdout,"%d\n",val);
					break;
				case 'F':
					if(countCharArray(argv[3]) > 8){
						fprintf(stderr,"ERROR: This conversion is not possible.\n");
						return 1;
					}
					hexaToFloat(argv[3]);
					break;
				case 'H':
					fprintf(stdout,"0x%s\n",argv[3]);
					break;
				case 'D':
					if(countCharArray(argv[3]) > 8){
						fprintf(stderr,"ERROR: This conversion is not possible.\n");
						return 1;
					}
					hexaToDouble(argv[3]);
				default:
					fprintf(stderr, "ERROR: The output argument is wrong.\nPossible output arguments are -B, -H, -I, -F and -D.\n" );	//
				return 1;
			}
			
			break;
		case 'B':
			/*
				Check Binary input has valid size
			*/
			if (countCharArray(argv[3]) != 32 && countCharArray(argv[3]) != 64){

				fprintf(stderr, "ERROR: The input size is wrong. %d\n",countCharArray(argv[3]));
				return 1;
			}

			/*
				Switch the output arguments
			*/
			switch(argv[2][1]){
				case 'H':
					binaryToHexa(argv[3]);
					break;
				case 'I':
					if(countCharArray(argv[3]) > 32){
						fprintf(stderr,"ERROR: This conversion is not possible.\n");
						return 1;
					}
					val = binaryToInt(argv[3]);
					fprintf(stdout,"%d\n",val);
					break;
				case 'F':
					if(countCharArray(argv[3]) > 32){
						fprintf(stderr,"ERROR: This conversion is not possible.\n");
						return 1;
					}
					binaryToFloat(argv[3]);
					break;
				case 'B':

					fprintf(stdout,"%s\n",argv[3]);
					break;
				case 'D':
					binaryToDouble(argv[3]);
				default:
				fprintf(stderr, "ERROR: The output argument is wrong.\nPossible output arguments are -B, -H, -I, -F and -D.\n" );
				return 1;
			}
			break;
		case 'I':
			/*
			 * Check the input is in correct format
			 * 
			*/
			
			for (i = 0; i < countCharArray(argv[3]); i++){
				if (!(argv[3][0] == '-' || argv[3][i] == '0' || argv[3][i] == '1' || argv[3][i] == '2' || argv[3][i] == '3' || argv[3][i] == '4' || argv[3][i] == '5'|| argv[3][i] == '6' || argv[3][i] == '7' || argv[3][i] == '8'|| argv[3][i] == '9')) {
					fprintf(stderr,"ERROR: Input format error at location %d.\n",i);
					exit(1);
				}

			}
			
			
			
			/*
				Switch the output arguments
			*/
			switch(argv[2][1]){
				case 'B':
					arr = intToBinaryC(argv[3]);
					// intToBinaryC(argv[3]);
					fprintf(stdout,"%s\n", arr);
					break;
				case 'H':
					intToHexa(argv[3]);
					break;
				case 'F':
					intToFloat(argv[3]);
				
					
					break;
					
				case 'I':
					fprintf(stdout,"%s\n",argv[3]);
					break;
				case 'D':
					//intToDouble(argv[3]);
				default:
				fprintf(stderr, "ERROR: The output argument is wrong.\nPossible output arguments are -B, -H, -I, -F and -D.\n" );
				return 1;	
			}
			break;
		case 'F':

			/*
				Switch the output arguments
			*/
			switch(argv[2][1]){
				case 'F':
					fprintf(stdout,"%s\n",argv[3]);
					break;
				case 'B':
					floatToBinary(argv[3]);
					break;
				case 'I':
					if(doubleVal(argv[3]) > 2147483647){
						fprintf(stderr,"ERROR: This conversion is not possible.\n");
						return 1;
					}
					fprintf(stderr,"WARNING:  There is a possibility for a precision loss.\n");
					floatToInt(argv[3]);
					break;
					
				case 'H':
					floatToHexa(argv[3]);
					break;
				case 'D':
					fprintf(stderr,"ERROR: This conversion is not possible.\n");
					return 1;
					
				default:
				fprintf(stderr, "ERROR: The output argument is wrong.\nPossible output arguments are -B, -H, -I, -F and -D.\n");
				return 1;
				
			}
			break;
			case 'D':
				dotCount = 0;
				for (i = 0; i < countCharArray(argv[3]); i++){
					if(argv[3][i] == '.')dotCount++;
					if(dotCount==2 ){
						fprintf(stderr,"ERROR: Input format error at location %d.\n",i);
						exit(1);
					}
					if (!(argv[3][i] == '.' || argv[3][0] == '-' || argv[3][i] == '0' || argv[3][i] == '1' || argv[3][i] == '2' || argv[3][i] == '3' || argv[3][i] == '4' || argv[3][i] == '5'|| argv[3][i] == '6' || argv[3][i] == '7' || argv[3][i] == '8'|| argv[3][i] == '9')) {
						fprintf(stderr,"ERROR: Input format error at location %d.\n",i);
						exit(1);
					}
					
				}
				
				/*
					Switch the output arguments
				*/
				switch(argv[2][1]){
				case 'F':
					fprintf(stderr,"ERROR: This conversion is not possible.\n");
					return 1;
					
				case 'B':
					doubleToBinary(argv[3]);
					break;
				case 'I':
					fprintf(stderr,"ERROR: This conversion is not possible.\n");
					return 1;
					
				case 'H':
					floatToHexa(argv[3]);
					break;
				case 'D':
					fprintf(stdout,"%s\n",argv[3]);
				default:
				fprintf(stderr, "ERROR: The output argument is wrong.\nPossible output arguments are -B, -H, -I, -F and -D.\n" );
				return 1;
				
			}
			break;
				
			default:
				fprintf(stderr, "ERROR: The input argument is wrong.\nPossible input arguments are -B, -H, -I, -F and -D.\n" );	// If input argument not match for any of valid input then produce an error.
				return 1;
	}

	return 0;
}

/*
	Function for Conversion of Binary to Hexadecimal
*/
void binaryToHexa(char *input){
	fprintf(stdout,"0x");
		
	int i;
	for(i = 0;i<countCharArray(input);){
		
		char a[] = {input[i],input[i+1],input[i+2],input[i+3],'\0'};
		//fprintf(stdout,"%s\n",a);
		if(stringcompare(a,"0000") == 0){
				fprintf(stdout,"0");
		} else if(stringcompare(a,"0001") == 0){
				fprintf(stdout,"1");
		} else if(stringcompare(a,"0010") == 0){
				fprintf(stdout,"2");
		} else if(stringcompare(a,"0011") == 0){
				fprintf(stdout,"3");
		} else if(stringcompare(a,"0100") == 0){
				fprintf(stdout,"4");
		} else if(stringcompare(a,"0101") == 0){
				fprintf(stdout,"5");
		} else if(stringcompare(a,"0110") == 0){
				fprintf(stdout,"6");
		} else if(stringcompare(a,"0111") == 0){
				fprintf(stdout,"7");
		} else if(stringcompare(a,"1000") == 0){
				fprintf(stdout,"8");
		} else if(stringcompare(a,"1001") == 0){
				fprintf(stdout,"9");
		} else if(stringcompare(a,"1010") == 0){
				fprintf(stdout,"A");
		} else if(stringcompare(a,"1011") == 0){
				fprintf(stdout,"B");
		} else if(stringcompare(a,"1100") == 0){
				fprintf(stdout,"C");
		} else if(stringcompare(a,"1101") == 0){
				fprintf(stdout,"D");
		} else if(stringcompare(a,"1110") == 0){
				fprintf(stdout,"E");
		} else if(stringcompare(a,"1111") == 0){
				fprintf(stdout,"F");
		}
			
		i+=4;
	}
	fprintf(stdout,"\n");
}


/*
	Function for Conversion of Binary to Integer
*/
int binaryToInt(char *input){
	if(countCharArray(input) == 32){
		if(input[0] == '0'){
			int i;
			int val = 0;
			int j=0;
			for(i = 31;i>=0;i--){
				if(input[i] == '1'){
					val += powd(2,j);
					
				}else if(input[i] != '0'){
					fprintf(stderr,"ERROR: Input format error at location %d.\n",i);
					exit(1);
				}
				j++;
			}
			//fprintf(stdout,"%d\n",val);
			return val;
		} else {
			int i;
			
			if(input[31] == '0'){
			
				for(i=30;i>=0;i--){
					if(input[i] == '1'){
						input[i] = '0';
						break;
					}else{
						input[i] = '1';
						continue;
					}
				}
				input[31]='1';
			} else {
				input[31]='0';
			
			}
			
			// invert of 1s compliment
			for(i=0;i<32;i++){
				if(input[i] == '1'){	
					input[i] = '0';
				}else if(input[i] == '0'){
					input[i] = '1';
				}else{
					fprintf(stderr,"ERROR: Input format error at location %d.\n",i);
					exit(1);
				}
			}
			int j=0;
			int val = 0;
			for(i = 31;i>=0;i--){
				if(input[i] == '1'){
					val += powd(2,j);
					
				}
				j++;
			}
			return -val;
		}
	}else{
		if(input[0] == '0'){
			int i;
			int val = 0;
			int j=0;
			for(i = 63;i>=0;i--){
				if(input[i] == '1'){
					val += powd(2,j);
					
				}else if(input[i] != '0'){
					fprintf(stderr,"ERROR: Input format error at location %d.\n",i);
					exit(1);
				}
				j++;
			}
			//fprintf(stdout,"%d\n",val);
			return val;
		} else {
			int i;
			
			if(input[63] == '0'){
			
				for(i=62;i>=0;i--){
					if(input[i] == '1'){
						input[i] = '0';
						break;
					}else if(input[i] == '0'){
						input[i] = '1';
						continue;
					}else{
						fprintf(stderr,"ERROR: Input format error at location %d.\n",i);
						exit(1);
					}
				}
				input[63]='1';
			} else {
				input[63]='0';
			
			}
			
			// invert of 1s compliment
			for(i=0;i<64;i++){
				if(input[i] == '1'){	
					input[i] = '0';
				}else if(input[i] == '0'){
					input[i] = '1';
				}
			}
			int j=0;
			int val = 0;
			for(i = 63;i>=0;i--){
				if(input[i] == '1'){
					val += powd(2,j);
					
				}
				j++;
			}
			return -val;
		}
	}
}

/*
	Function for Conversion of Binary to Single Precision
*/
void binaryToFloat(char *input){
	//~ float f = binaryToInt(input);
	//~ fprintf(stdout,"%.02f\n",f);
	if (countCharArray(input) != 32){
		fprintf(stderr, "ERROR: This conversion is not possible.\n" );
		return 1;
	}

	char exponent[8];
	int i,j;
	for (i = 1,j=0; i < 9; j++,++i)	{
		exponent[j] = input[i];
	}
	exponent[8] = '\0';
	int exponetVal = 0;
	j=0;
	for(i = 7;i>=0;i--){
		if(exponent[i] == '1'){
			exponetVal += powd(2,j);
			
		}
		j++;
	}
	exponetVal -= 127;
	char integerDigits[exponetVal+1];
	integerDigits[0] = '1';
	for (i = 9,j=1; j < exponetVal+1; j++,++i)	{
		integerDigits[j] = input[i];
	}
	int integerValue = 0;
	for(i = exponetVal,j=0;i>=0;i--){
		if(integerDigits[i] == '1'){
			integerValue += powd(2,j);
			
		}
		j++;
	}
	
	char significant[23-exponetVal];
	for (i = 9 + exponetVal,j=0; i < 32; j++,++i)	{
		significant[j] = input[i];
	}
	significant[23-exponetVal] = '\0';
	
	double decimalValue = 0;
	for(i = 0,j=-1;i<countCharArray(&significant);i++){
		if(significant[i] == '1'){
			decimalValue += powd(2,j);
			//~ printf("%lf\n",decimalValue);
		}
		j--;
	}
	float finalFloatValue = (integerValue+decimalValue);
	if(input[0] == '1'){
		finalFloatValue *= -1;
	}
	
	fprintf(stdout, "%.02f\n", finalFloatValue);
	
}

/*
	Function for Conversion of Binary to Double Precision
*/
void binaryToDouble(char *input){
	//~ float f = binaryToInt(input);
	//~ fprintf(stdout,"%.06f\n",f);
	
	char exponent[11];
	int i,j;
	for (i = 1,j=0; i < 12; j++,++i)	{
		exponent[j] = input[i];
	}
	exponent[12] = '\0';
	int exponetVal = 0;
	j=0;
	for(i = 10;i>=0;i--){
		if(exponent[i] == '1'){
			exponetVal += powd(2,j);
			
		}
		j++;
	}
	exponetVal -= 1023;
	char integerDigits[exponetVal+1];
	integerDigits[0] = '1';
	for (i = 12,j=1; j < exponetVal+1; j++,++i)	{
		integerDigits[j] = input[i];
	}
	int integerValue = 0;
	for(i = exponetVal,j=0;i>=0;i--){
		if(integerDigits[i] == '1'){
			integerValue += powd(2,j);
			
		}
		j++;
	}
	
	char significant[52-exponetVal];
	for (i = 12 + exponetVal,j=0; i < 64; j++,++i)	{
		significant[j] = input[i];
	}
	significant[52-exponetVal] = '\0';
	
	double decimalValue = 0;
	for(i = 0,j=-1;i<countCharArray(&significant);i++){
		if(significant[i] == '1'){
			decimalValue += powd(2,j);
			//~ printf("%lf\n",decimalValue);
		}
		j--;
	}
	double finalFloatValue = (integerValue+decimalValue);
	if(input[0] == '1'){
		finalFloatValue *= -1;
	}
	
	fprintf(stdout, "%.06lf\n", finalFloatValue);
}



/*
	Function for Conversion of Hexadecimal to Binary
*/
void hexaToBinary(char *input){
	
	
	
	int i;
	for(i=0;i< countCharArray(input);i++){
		switch(input[i]){
			case '0':
				fprintf(stdout,"0000");
				break;
				
			case '1':
				fprintf(stdout,"0001");
				break;
				
			case '2':
				fprintf(stdout,"0010");
				break;
				
			case '3':
				fprintf(stdout,"0011");
				break;
				
			case '4':
				fprintf(stdout,"0100");
				break;
				
			case '5':
				fprintf(stdout,"0101");
				break;
				
			case '6':
				fprintf(stdout,"0110");
				break;
				
			case '7':
				fprintf(stdout,"0111");
				break;
				
			case '8':
				fprintf(stdout,"1000");
				break;
				
			case '9':
				fprintf(stdout,"1001");
				break;
				
			case 'A':
				fprintf(stdout,"1010");
				break;
				
			case 'B':
				fprintf(stdout,"1011");
				break;
				
			case 'C':
				fprintf(stdout,"1100");
				break;
				
			case 'D':
				fprintf(stdout,"1101");
				break;
				
			case 'E':
				fprintf(stdout,"1110");
				break;
				
			case 'F':
				fprintf(stdout,"1111");
				break;
			default:
				fprintf(stderr,"ERROR: Input format error at location %d.\n",i);
				exit(1);
		}
		
	}
	fprintf(stdout,"\n");
}

/*
	Function for Conversion of Hexadecimal to Integer
*/
int hexaToInt(char *input){
	int i;
	int val = 0;
	int j=0;
	for(i = 7;i>=0;i--){
		
		switch(input[i]){
			case '0':
				
				break;
				
			case '1':
				val += 1 * powd(16,j);
				break;
				
			case '2':
				val += 2 * powd(16,j);
				break;
				
			case '3':
				val += 3 * powd(16,j);
				break;
				
			case '4':
				val += 4 * powd(16,j);
				break;
				
			case '5':
				val += 5 * powd(16,j);
				break;
				
			case '6':
				val += 6 * powd(16,j);
				break;
				
			case '7':
				val += 7 * powd(16,j);
				break;
				
			case '8':
				val += 8 * powd(16,j);
				break;
				
			case '9':
				val += 9 * powd(16,j);
				break;
				
			case 'A':
				val += 10* powd(16,j);
				break;
				
			case 'B':
				val += 11 * powd(16,j);
				break;
				
			case 'C':
				val += 12 * powd(16,j);
				break;
				
			case 'D':
				val += 13 * powd(16,j);
				break;
				
			case 'E':
				val += 14 * powd(16,j);
				break;
				
			case 'F':
				val += 15 * powd(16,j);
				break;
			default:
				fprintf(stderr,"ERROR: Input format error at location %d.\n",i);
				exit(1);
		}
		
		
		
		j++;
	}
	//fprintf(stdout,"%d\n",val);
	return val;
}



/*
	Function for Conversion of Hexadecimal to Single precision
*/
void hexaToFloat(char *input){
	
	float f= hexaToInt(input);
	fprintf(stdout,"%.02f\n",f);
	
}


/*
	Function for Conversion of Hexadecimal to Double precision
*/
void hexaToDouble(char *input){
	
	float f= hexaToInt(input);
	fprintf(stdout,"%.06f\n",f);
	
}


/*
	Function for Conversion of Integer to Hexadecimal
*/
void intToHexa(char *input){
	// first convert as binary
	int num = intVal(input);
	static char ar[32];
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
		//fprintf(stdout,"%s\n",ar);
		for(i=0;i<32;i++){
			if(ar[i] == '1'){	
				ar[i] = '0';
			}else if(ar[i] == '0'){
				ar[i] = '1';
			}
		}
		//fprintf(stdout,"%s\n",ar);
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
		//fprintf(stdout,"%s\n",ar);
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


/*
	Function for Conversion of Integer to Binary
	@param int
	@return char*
*/
char * intToBinaryI(int num){
	if(num >= 0){
		int temp = num;
		static char ar[32];
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
		
		return &ar;
	}else {
		int temp = -num;
		static char ar[32];
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
		for(i=0;i<32;i++){
			if(ar[i] == '1'){	
				ar[i] = '0';
			}else if(ar[i] == '0'){
				ar[i] = '1';
			}
		}
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
		return &ar;
	}
	
}


/*
	Function for Conversion of Integer to Binary
	@param char*
	@return char*
*/
char * intToBinaryC(char *input){
	int num = intVal(input);
	return intToBinaryI(num);
}



/*
	Function for Conversion of Float to Binary
*/
void floatToBinary(char *input){
	
	double f = doubleVal(input);
	
	
	int dotIndex;
	int i;
	int len = countCharArray(input);
	for (i = 0; i < len; ++i){
		if (input[i] == '.'){
			dotIndex = i;
			break;
		}
	}
	char intValue[dotIndex];
	for (i = 0; i < dotIndex; ++i){
		intValue[i] = input[i];
	}
	intValue[i] = '\0';
	
	if (intValue[0] == '-')	{
		intValue[0] = '0';
	}
	

	char *binaryInteger = intToBinaryC(intValue);

	double floatingDigits= f - (int)f; 
	
	char fDigits[23];
	i=0;
	while(i < 23){
		int temp = floatingDigits * 2;
		floatingDigits = (floatingDigits * 2) - temp;
		fDigits[i] = temp == 0 ? '0' : '1';
		i++;
	}
	fDigits[23] = '\0';
	
	char ieeefloat[32];
	
	for (i = 0; i < 32; ++i){
		ieeefloat[i] = '0';
	}
	

	int startPoint;
	for (i = 1; i < 32; ++i){
		if (binaryInteger[i] == '1'){
			startPoint = i;
			break;
		}

	}
	
	int j;
	for (i = startPoint+1, j = 9; i < 32; ++i,j++){
		ieeefloat[j] = binaryInteger[i];
	}
	
	int exponent = i - startPoint - 1;
	
	for (i = j, j=0; i < 32; ++i,j++){
		ieeefloat[i] = fDigits[j];
	}
	
	ieeefloat[32] = '\0';

	char *expBinary = intToBinaryI(exponent+127);


	for (i = 0; i < 32; ++i){
		if (expBinary[i] == '1'){
			startPoint = i;
			break;
		}

	}

	for (i = startPoint, j = 1; i < 32; ++i,j++){
		ieeefloat[j] = expBinary[i];
	}

	if (input[0]=='-'){
		ieeefloat[0] = '1';
	}
	fprintf(stdout,"%s\n", ieeefloat);
}


/*
	Function for Conversion of Float to Hexadecimal
*/
void floatToHexa(char *input){
	//float f = atof(input);
	
}



/*
	Function for Conversion of Double to Binary
*/
void doubleToBinary(char *input){

	double f = doubleVal(input);
	fprintf(stdout,"%lf\n", f);
	int dotIndex;
	int i;
	int len = countCharArray(input);
	for (i = 0; i < len; ++i){
		if (input[i] == '.'){
			dotIndex = i;
			break;
		}
	}
	char intValue[dotIndex];
	for (i = 0; i < dotIndex; ++i){
		intValue[i] = input[i];
	}
	intValue[i] = '\0';
	
	

	char *binaryInteger = intToBinaryC(intValue);

	double floatingDigits= f - (int)f; 
	char fDigits[52];
	i=0;
	while(i < 52){
		int temp = floatingDigits * 2;
		floatingDigits = (floatingDigits * 2) - temp;
		fDigits[i] = temp == 0 ? '0' : '1';
		i++;
	}
	fDigits[52] = '\0';
	char ieeefloat[64];
	
	for (i = 0; i < 64; ++i){
		ieeefloat[i] = '0';
	}
	

	int startPoint;
	for (i = 1; i < 32; ++i){
		if (binaryInteger[i] == '1'){
			startPoint = i;
			break;
		}

	}
	int j;
	for (i = startPoint+1, j = 12; i < 32; ++i,j++){
		ieeefloat[j] = binaryInteger[i];
	}
	int exponent = i - startPoint - 1;

	for (i = j, j=0; i < 64; ++i,j++){
		ieeefloat[i] = fDigits[j];
	}

	char *expBinary = intToBinaryI(exponent+1023);

	for (i = 0; i < 32; ++i){
		if (expBinary[i] == '1'){
			startPoint = i;
			break;
		}

	}

	for (i = startPoint, j = 1; i < 32; ++i,j++){
		ieeefloat[j] = expBinary[i];
	}
	if (input[0]=='-'){
		ieeefloat[0] = '1';
	}
	ieeefloat[64] = '\0';
	fprintf(stdout,"%s\n", ieeefloat);
}


/*
	Function for Conversion of Integer to Float
*/
void intToFloat(char *input){
	float f = intVal(input);
	fprintf(stdout,"%.02f\n",f);
}


/*
	Function for Conversion of Float to Integer
*/
void floatToInt(char *input){
	int value = (int)doubleVal(input);
	if(input[0] == '-'){
		value *= -1;
	}
	fprintf(stdout,"%d\n",value);
}


// User defined utility functions....

/*
	Function to get the element count of char array
	@param char*
	@return int
*/
int countCharArray(char *arr){
	int i;

	for (i = 0; i < 128; ++i){
		if (arr[i] == '\0')	{
			// puts("Ela Awa....");
			return i;
		}
	}
	return 0;
}


/*
	Function to get the power
	Can be both positive and negative power, base can be only integer
	@param int , int
	@return double
*/
double powd(int a, int b){
    if(b>=0){
    	if(b == 0){
            return 1;
        }
        int val = a;
        int i;
        for (i = 1; i < b; ++i) {
            val *= a;
        }
        return val;
    }else{
    	 double val = 1.0/a;
        int i;
        for (i = 1; i < -b; ++i) {
            val /= (double)a;
        }
        return val;
    }
}


/*
	Function for check the two strings are equal or not
	@return int
		if two strings are same then return 0 unless 1
*/
int stringcompare(char *str1, char *str2){
	//fprintf(stdout,"%d		%d\n",countCharArray(str1), countCharArray(str2));
	if(countCharArray(str1) != countCharArray(str2)){
		return 1;
	}
	int i;
	for (i = 0; i < countCharArray(str2); ++i){
		if(str1[i] != str2[i]){
			return 1;
		}
	}
	return 0;
}


/*
	Function for get the integer value of string (Parse the string to integer)
*/
int intVal(char *input){
	int len = countCharArray(input);
	int val = 0;
	int i;
	int j;
	for (i = len-1,j=0; i >=0; --i,j++){
 
		switch(input[i]){
			case '0':
				
				break;
				
			case '1':
				val += 1 * powd(10,j);
				break;
				
			case '2':
				val += 2 * powd(10,j);
				break;
				
			case '3':
				val += 3 * powd(10,j);
				break;
				
			case '4':
				val += 4 * powd(10,j);
				break;
				
			case '5':
				val += 5 * powd(10,j);
				break;
				
			case '6':
				val += 6 * powd(10,j);
				break;
				
			case '7':
				val += 7 * powd(10,j);
				break;
				
			case '8':
				val += 8 * powd(10,j);
				break;
				
			case '9':
				val += 9 * powd(10,j);
				break;
			case '-': break;
			default:
				fprintf(stderr,"ERROR: Input format error at location %d.\n",i);
				exit(1);
		}

		//
	}
	 if(input[0] == '-'){
		val *= -1;
	}
	
	return val;
}


/*
	Function for get the double value of string
*/
double doubleVal(char *input){
	int dotIndex;
	int i;
	int len = countCharArray(input);
	for (i = 0; i < len; ++i){
		if (input[i] == '.'){
			dotIndex = i;
			break;
		}
	}
	char intValue[dotIndex];
	for (i = 0; i < dotIndex; ++i){
		intValue[i] = input[i];
	}
	intValue[i] = '\0';
	
	double value = (double)intVal(intValue);
	//~ if(value > 2147483647){
		//~ fprintf(stderr,"ERROR: This conversion is not possible.\n");
		//~ return 1;
	//~ }
	if (value<0){
		value *= -1;
	}
	
	int j;
	for (i = dotIndex+1,j=-1; i < len; ++i,j--){
		switch(input[i]){
			case '0': break;
			case '1':
				
				value += 1 * powd(10,j);
				
				break;
				
			case '2':
				value += 2 * powd(10,j);
				break;
				
			case '3':
				value += 3 * powd(10,j);
				break;
				
			case '4':
				value += 4 * powd(10,j);
				break;
				
			case '5':
				value += 5 * powd(10,j);
				break;
				
			case '6':
				value += 6 * powd(10,j);
				break;
				
			case '7':
				value += 7 * powd(10,j);
				break;
				
			case '8':
				value += 8 * powd(10,j);
				break;
				
			case '9':
				value += 9 * powd(10,j);
				break;
			case '-': break;
			default:
				fprintf(stderr,"ERROR: Input format error at location %d.\n",i);
				exit(1);
		}
	}

	return value;
}
