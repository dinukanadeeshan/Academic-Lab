#include <stdio.h>



int main(int argc, char **argv){
	int count=0;
	int i;
	
	for(i=2;i<argc;i++){
		int j;
		//printf("%ld\n",(sizeof(argv[i])/sizeof(argv[i][0])));
		for(j=0;j<sizeof(argv[i]);j++){
			int l=0;
			int k;
			for(k=0;k<sizeof(argv[i]);k++){
				if(&argv[i][j] == &argv[i+1][k]){
					l = 1;
					break;
				}
			}
			
			if(l != 1){
				
				if(argv[i][j] == argv[1][0]){
				//	printf("%d == %d (%d) %d %s\n",&argv[i][j],&argv[1][0],j,i,argv[i]);
					count++;
				}
			}
		}
	}
	
	printf("The occurrences of \"%c\" in the text is %d.\n",argv[1][0],count);
	
}

