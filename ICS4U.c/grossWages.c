#include <stdio.h>

double overtime( int hours, double hourlyPay);

int main() {

	//variables
	int hours;
	double hourlyPay = 0;

	//intro
	printf("Gross Wage Calculator\n");

	//getting input
	printf("Enter number of hours worked: ");
	scanf("%d", &hours);

	printf("Enter hourly wage: ");
	scanf("%lf", &hourlyPay);

	double wage = overtime( hours, hourlyPay);

	printf("Gross Wage: $%.2lf. \n", wage);
	
	return 0;

}

double overtime( int hours, double hourlyPay) {

	double wage;

	if (hours <= 40) {

		wage = hours * hourlyPay;

	} else {

		wage = (40 * hourlyPay) + ( (hours - 40) * (hourlyPay * 1.5) );

	}

	return wage;
}



