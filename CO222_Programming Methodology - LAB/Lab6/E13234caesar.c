
#include <stdio.h>
#include <string.h>

int rotateright(int ch); 
int rotateleft(int ch);
int encode(int ch, int shift);



int main(){

	int shift;
	printf("Enter shift: ");
	scanf("%d", &shift);

	char text[200];
	printf("Enter text: \n");
	

	int ch = getchar();


	int i=0;
	while ((ch = getchar()) != -1 && i < 200) {
		
		text[i] = ch;
		i++;
		   	
	}
	text[i-1] = '\0';
	for (i = 0; i < sizeof(text); ++i){
		text[i] = encode(text[i],shift);

	}

	printf("Here is the encoded text:\n%s",text);

}

int rotateright(int ch){
	int rotch;
	if(ch >= 65 && ch <= 90){
		rotch = ++ch;
		if(rotch > 90){
			rotch = 65;
		}
	}else if(ch >= 97 && ch <= 122){
		rotch = ++ch;
		if(rotch > 122){
			rotch = 97;
		}
	}else{
		rotch = ch;
	}



	return rotch;

}

int rotateleft(int ch){
	int rotch;
	if(ch >= 65 && ch <= 90){
		rotch = --ch;
		if(rotch < 65){
			rotch = 90;
		}
	}else if(ch >= 97 && ch <= 122){
		rotch = --ch;
		if(rotch < 97){
			rotch = 122;
		}
	}else{
		rotch = ch;
	}



	return rotch;

}

int encode(int ch, int shift){
	
	if(shift >= 0){
		int i;
		for ( i = 0; i < shift; ++i)	{
			ch = rotateright(ch);
		}
		
	}else{
		int i;
		for ( i = 0; i < -shift; ++i)	{
			ch = rotateleft(ch);
		}
	}
	return ch;
}

