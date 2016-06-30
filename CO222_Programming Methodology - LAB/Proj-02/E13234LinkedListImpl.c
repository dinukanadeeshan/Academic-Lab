

#include <stdio.h>
#include <stdlib.h>

#include "StackAndQueue.h"

typedef struct  node Node;

struct node{
	int value;
	Node *next;
};

struct stack{
	Node *data;
};

struct queue{
	Node *rear;
	Node *front;
};

/*
	Create new stack

*/
Stack* CreateStack(){
	return (Stack*) malloc(sizeof(Stack));
}

int StackPush(Stack* stack, int value){
	Node *newNode = (Node*)malloc(sizeof(Node));
	newNode -> value = value;
	newNode -> next = stack -> data;

	stack -> data = newNode;
	return 0;
}


int StackPop(Stack* stack, int* value){
	*value = stack -> data -> value;
	Node *temp = stack -> data;
	stack -> data = stack -> data -> next;
	free(temp);

	return 0;
}


int DeleteStack(Stack *stack){
	
	free(stack);
	return 0;
}

int StackPeek(const Stack* stack, int* value){
	*value = stack -> data -> value;
	return 0;
}


Queue* CreateQueue(){
	return (Queue*) malloc(sizeof(Queue));
}

int QueueEnqueue(Queue *queue, int value){
	Node *newNode = (Node*)malloc(sizeof(Node));
	newNode -> value = value;
	if (queue->front == NULL){
		queue->front = newNode;
	}

	if (queue -> rear != NULL){
		queue -> rear -> next = newNode;
	}

	

	queue -> rear = newNode;

	return 0;

}

int QueueDequeue(Queue* queue, int* value){
	*value = queue -> front -> value;
	Node* temp = queue -> front;
	queue -> front = queue -> front -> next;

	free(temp);

	return 0;

}

int QueuePeek(const Queue* queue, int* value){
	*value = queue -> front -> value;

	return 0;
}

int DeleteQueue(Queue* queue){
	free(queue);
	return 0;
}