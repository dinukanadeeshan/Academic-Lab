#include <stdio.h>
#include <stdlib.h>
typedef struct customer Customer;
struct customer{
	int code;
	Customer *next;
};
void insert(Customer **front, Customer **rear, int code);
void printCustomer(Customer *front);
void removeCustomer(Customer **front);
int size(Customer *front);

int main(){
	Customer *front=NULL;
	Customer *rear=NULL;
	insert(&front, &rear, 1001);
	insert(&front, &rear, 1002);
	insert(&front, &rear, 1003);
	insert(&front, &rear, 1004);
	printCustomer(front);
	removeCustomer(&front);
	printCustomer(front);
	printf("%d\n", size(front));
	return 0;
} 

void insert(Customer **front, Customer **rear,int code){
	Customer *temp=malloc(sizeof(Customer));	
	temp->code=code;
	temp->next=NULL;
	if(*front==NULL){
		*front = temp;
	}
	if(*rear!=NULL){
		(*rear)->next = temp;
	}
	*rear=temp;
}

void printCustomer(Customer *front){
	while(front!=NULL){
		printf("%d ",front->code);
		front=front->next;
	}
	printf("\n");
}

void removeCustomer(Customer **front){
	Customer *temp;
	temp=*front;
	*front=temp->next;
	free(temp);
}

int size(Customer *front){
	int count=0;
	while(front!=NULL){
		count++;
		front = front->next;
	}
	return count;
}

