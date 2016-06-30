#include<stdio.h> 
#include <math.h>
#include <complex.h>

int main(){
	double a,b,c;
	printf("Enter the coefficients: ");
	scanf("%lf %lf %lf",&a,&b,&c);
	double d=pow(b,2) - (4*a*c);

	if(d>0){
		double sol1 = (-b + sqrt(d))/ (2*a);
		double sol2 = (-b - sqrt(d))/ (2*a);
		printf("The solutions are: %.2f and %.2f\n", sol2, sol1);
	}else if(d==0){
		double sol = -b/(2*a);
		printf("The solution is: %.2f \n",sol);
	}else{
		double real = -b/(2*a);
		double img = sqrt(-d)/(2*a);

		if(real != 0){
			printf("The solutions are: %.2f - %.2fi and  %.2f + %.2fi \n",real,img,real,img);		
		}else{
			printf("The solutions are: - %.2fi and %.2fi \n",img,img);
		}
		
	}
	
	return 0;
}
