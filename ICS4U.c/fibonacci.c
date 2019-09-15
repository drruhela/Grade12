#include <stdio.h>

int main() {

	//intro
	printf("Fibonacci Series \n");

	//getting input
	int input;

	printf("How many numbers would you like to display?: ");
	scanf("%i", &input);

	//constants
	#define TERMS_TO_DISPLAY input

	//variables
	long a = 1, b = 2, c = a + b;

	printf("%d %d ", a, b);

	//logic
	for (int i = 0; i < TERMS_TO_DISPLAY - 2; ++i)
	{
		printf("%d ", c);

		a = b;
		b = c;
		c = a + b;
	}

	return 0;

}