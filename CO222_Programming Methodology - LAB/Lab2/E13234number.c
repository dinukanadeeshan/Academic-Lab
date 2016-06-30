#include<stdio.h>

int main(){
	int num;
	printf("Enter a number: ");
	scanf("%d", &num);
	
	int isSpec = 0;
	int isBig = 0;
	int isWeird = 0;
	
	if(num%15 == 0){	//Check wheather special
		isSpec = 1;
	}
	
	if(num > 999){		//Check wheather big
		isBig = 1;
	}
	
	if(num % 5==0 && num % 6 == 0 && num % 18 != 0){ //Check wheather weird
		isWeird = 1;
	}
	
	if(isBig == 1){														//If Big number
		if(isWeird == 1){												//If weird number
			if(isSpec == 1){											//If special number
				printf("%d is special, big, weird and scary.\n",num);
			}else{														//If not special number
				printf("%d is not special, but scary.\n",num);
			}
		}else{															//If not weird number
			if(isSpec == 1){
				printf("%d is special, big and scary but not weird.\n",num);
			}else{														//If not special number
				printf("%d is not special, big and scary but not weird.\n",num);
			}
		}
	}else{																//If not Big number
		if(isWeird == 1){
			if(isSpec == 1){
				printf("%d is special, weird and scary but not big.\n",num);
			}else{														//If not special number
				printf("%d is not special, weird and scary but not big.\n",num);
			}
		}else{															//If not weird number
			if(isSpec ==1){
				printf("%d is special but not scary.\n",num);
			}else{														//If not special number
				printf("%d is not special or not scary.\n",num);
			}
		}
	}
	
	return 0;
}

