#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
	int numOfStats = 0;

	//intro
	printf("Golf Stats\n");

	while (numOfStats <= 0) {

		printf("Enter number of scores: ");
		scanf("%i", &numOfStats);

	}

	int scores[numOfStats];

	//getting and adding scores to array
	for (int i = 1; i <= sizeof(scores) / sizeof(int); i++) {

		int score;

		if (i % 10 == 1) {
			printf("Enter %ist score: ", i);
		}

		else if (i % 10 == 2) {
			printf("Enter %ind score: ", i);
		}

		else {
			printf("Enter %ith score: ", i);
		}

		scanf("%i", &score);
		scores[i-1] = score;

	}

	//printing scores and finding sum, min, and max
	int sum = 0;
	int max = scores[0];
	int min = scores[0];

	printf("Scores:_____\n");
	for (int i = 0; i < sizeof(scores) / sizeof(int); i++) {
		
		printf("Hole %i | %i \n", i+1, scores[i]);

		sum += scores[i];

		if ( abs(scores[i]) > abs(max) ) {
			max = scores[i];
		}

		if ( abs(scores[i]) < abs(min) ) {
			min = scores[i];
		}

	}

	printf("Sum: %d\n", sum);
	printf("Worst hole: %i \n", max);
	printf("Best hole: %i \n", min);
	//idk how golf scoring works :)

	return 0;
}