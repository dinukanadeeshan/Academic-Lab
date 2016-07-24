#include <stdio.h>

typedef unsigned long long int ullint_t;
int main(){
	ullint_t k_1;	// = 0x0f0e0d0c0b0a0908LL;
	ullint_t k_2;	// = 0x0706050403020100LL;

	ullint_t p_1;	// = 0x6c61766975716520LL;
	ullint_t p_2;	// = 0x7469206564616d20LL;

	printf("Enter the key:\n");
	scanf("%16llx %16llx",&k_1,&k_2);	



	printf("Enter the plain text:\n");
	scanf("%16llx %16llx",&p_1,&p_2);


	//Round i
	p_1 = (p_1 >> 8)|(p_1 << (64 - 8));
	p_1 += p_2;
	p_1 = p_1 ^ k_2;

	p_2 = (p_2<<3) | (p_2>>(64 - 3));
	p_2 = p_1 ^ p_2;
		//End of Round i
	int i=0;
	while ( i < 31)	{

		//Prepare next state () keys
		k_1 = (k_1 >> 8)|(k_1 << (64 - 8));
		k_1 += k_2;

		k_1 = k_1 ^ i;
		k_2 = (k_2<<3) | (k_2>>(64 - 3));

		k_2 = k_2 ^ k_1;
		//End of preparing next state(2) keys
		//Round i
		p_1 = (p_1 >> 8)|(p_1 << (64 - 8));
		p_1 += p_2;
		p_1 = p_1 ^ k_2;

		p_2 = (p_2<<3) | (p_2>>(64 - 3));
		p_2 = p_1 ^ p_2;
		//End of Round i
		i++;
	}

	

	printf("%16llx %16llx\n", p_1,p_2);

	return 0;
}