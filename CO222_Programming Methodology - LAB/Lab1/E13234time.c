#include<stdio.h> 

int main(){
	int time,duration;
	printf("Enter the start time: ");
	scanf("%d",&time);
	printf("Enter the duration: ");
	scanf("%d",&duration);

	int m1 = time % 100;
	int h1 = time/100;

	int m2 = duration % 100;
	int h2 = duration/100;

	int summ = m1+m2;
	int sumh = h1+h2;
	
	if(summ >= 60){
		summ = summ - 60;
		sumh++;
	}

	if(sumh >= 24){
		sumh = sumh - 24;
	}

	printf("End time is %02d%02d.\n",sumh,summ);
	return 0;
}

