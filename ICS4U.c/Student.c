#include <stdio.h>
#include <string.h>
#include <assert.h>

struct Student {

	char name[50];
	char school[50];
	int age;
	char dob[8];
	int id;
};

void toString( struct Student student);

int main() {

	struct Student s1;

	strcpy(s1.name, "Bob Random");
	strcpy(s1.school, "Garth Webb");
	strcpy(s1.dob, "12-15-01");
	s1.age = 17;
	s1.id = 1;

	assert(strcmp(s1.name, "Bob Random") == 0);
	assert(strcmp(s1.school, "Garth Webb") == 0);
	assert(strcmp(s1.dob, "12-20-01") != 0);
	assert(s1.age == 17);

	toString(s1);

	return 0;

}

void toString( struct Student student) {


	printf("Id: %i, Name: %s, School: %s, Date of Birth: %s, Age: %i \n", student.id, student.name, student.school, student.dob, student.age);
	

}