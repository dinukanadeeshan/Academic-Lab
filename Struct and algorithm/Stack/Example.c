#include <stdio.h>
#include <stdlib.h>
typedef struct customer Customer;
struct customer{
	int code;
	Customer *next;	 
};
void push(Customer **cList,int code);
void printCustomer(Customer *cList);
void pop(Customer **cList);

int main(){
	Customer *cList=NULL;
	push(&cList,1001);
	push(&cList,1002);
	push(&cList,1003);
	push(&cList,1004);
	printCustomer(cList);
	pop(&cList);
	printCustomer(cList);
	return 0;
} 

void push(Customer **cList,int code){
	Customer *temp=malloc(sizeof(Customer));	
	temp->code=code;
	temp->next=*cList;
	*cList=temp;
}

void printCustomer(Customer *cList){
	while(cList!=NULL){
		printf("%d ",cList->code);
		cList=cList->next;
	}
	printf("\n");
}

void pop(Customer **cList){
	Customer *temp;
	temp=*cList;
	*cList=temp->next;
	free(temp);
}

