#include <stdio.h>

int main() {
	/* code */
	double pH;

	//background
	printf("Acid rain is an environmental issue that affects water bodies greatly.\n");
	printf("This program will determine whether the pH level of water bodies is safe for fish.\n");

	//getting input
	printf("Enter the pH level: ");
	scanf("%lf", &pH);

	//logic
	if (pH <= 2 || pH >= 12) {
		printf("Invalid input. \n");
	} 

	else if ( pH < 6.4) {
		printf("Too Acidic - Fish in streams, rivers, and lakes will not survive! \n");
	} 

	else if ( pH > 7.4) {
		printf("Too Alkaline - Fish in streams, rivers, and lakes will not survive! \n");
	} 

	else {
		printf("Neutral - Fish in streams, rivers and lakes will survive. \n");
	}

	return 0;
}