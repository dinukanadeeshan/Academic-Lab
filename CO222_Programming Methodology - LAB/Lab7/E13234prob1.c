#include <stdio.h>
int main(){
	printf("Enter N: ");
	int n;
	scanf("%d",&n);
	
	int j;
	for(j=0;j<n;j++){
		int i;
		for(i = 0; i<=j;i++){
			if(i < 26){
				printf("%c",(i+65));
			}else{
				printf("%c",((i-26)+65));
			}
			
		}
		printf("\n");
	}
	for(j=n-1;j>=0;j--){
		int i;
		for(i=j-1;i>=0;i--){
			if(i < 26){
				printf("%c",(i+65));
			}else{
				printf("%c",((i-26)+65));
			}
		}
		printf("\n");
	}
	
}

