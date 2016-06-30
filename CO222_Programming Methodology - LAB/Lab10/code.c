#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void insertStudent();
void printStudent();
void printAllStudents();
void deleteStudent();

typedef struct _ {
	int batch;
	int regNo;
	char firstName[20];
	char lastName[20];
	float cGPA;
}student_t;

student_t  students[1000];
int count = 0;

int main(){
	
	
	while(1){
		puts("----------------------------------------------");
		puts("A VOLATILE STUDENT RECORDS MAINTENANCE SYSTEM");
		puts("----------------------------------------------");
		puts("0. Quit");
		puts("1. Insert a Student record");
		puts("2. Print a Student Record");
		puts("3. Print all Student Records");
		puts("4. Delete a Student Record");
		int res;
		scanf("%d",&res);
		switch(res){

			case 0:
				return 0;

			case 1:
				insertStudent();
				break;
			case 2:
				printStudent();
				break;
			case 3:
				printAllStudents();
				break;
			case 4:
				deleteStudent();
				break;
		}
		
	}

	return 0;
}

void insertStudent(){
	student_t student;

	int batch,regNo;
	char fName[20];
	char lName[20];
	float cGPA;

	printf("Enter the batch(11/12/13/14) : ");
	scanf("%d",&batch);
	printf("Enter the registration number: ");
	scanf("%d",&regNo);
	printf("Enter the first name         : ");
	scanf("%s",fName);
	printf("Enter the last name          : ");
	scanf("%s",lName);
	printf("Enter the cumulative GPA     : ");
	scanf("%f",&cGPA);

	student.batch = batch;
	student.regNo = regNo;
	student.cGPA = cGPA;
	strcpy(student.firstName, fName);
	strcpy(student.lastName, lName);
	

	students[count] = student;
	

	count++;

}

void printStudent(){
	int regNo;
	printf("Enter the Registration number: ");
	scanf("%d",&regNo);

	int i;
	for(i=0;i<count;i++){
		if(students[i].regNo == regNo){
			printf("The student %s %s (E/%d/%d) has a cumulative GPA of %.02f\n", students[i].firstName, students[i].lastName, students[i].batch, students[i].regNo,students[i].cGPA);
		}
	}
	
}

void printAllStudents(){
	// printf("Number of students : %d\n", count);
	int i;
	for(i=0;i<count;i++){
		
		printf("The student %s %s (E/%d/%d) has a cumulative GPA of %.02f\n", students[i].firstName, students[i].lastName, students[i].batch, students[i].regNo,students[i].cGPA);
		
	}

}


void deleteStudent(){
	int regNo;
	printf("Enter the Registration number: ");
	scanf("%d",&regNo);

	int i;
	for(i=0;i<count;i++){
		if(students[i].regNo == regNo){
			break;
		}
	}


	int j;
	for(j=i; j<count-1;j++){
		students[j] = students[j+1];
	}
	count--;
}