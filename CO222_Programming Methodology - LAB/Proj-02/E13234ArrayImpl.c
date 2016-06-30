
#include <stdio.h>
#include <stdlib.h>

#include "StackAndQueue.h"

struct stack{
	int current;
	int *values;
};

struct queue{
	int rear;
	int *values;
};


/*
	Create new stack

*/
Stack* CreateStack(){

	return (Stack*) malloc(sizeof(Stack));
}

int StackPush(Stack* stack, int value){
	if (stack -> values == NULL){
		stack -> current = 0;
		stack -> values = (int*) malloc(sizeof(int));	
	}

	(stack -> values)[stack->current] = value;
	(stack -> current)++;

	return 0;
}


int StackPop(Stack* stack, int* value){
	if (stack -> current <= 0){
		return 1;
	}
	*value = (stack -> values)[stack->current];
	(stack -> current)--;	
	return 0;
}


int DeleteStack(Stack *stack){
	free(stack->values);
	free(stack);
	return 0;
}

int StackPeek(const Stack* stack, int* value){
	*value = (stack -> values)[stack->current];

	return 0;
}


Queue* CreateQueue(){
	
	return (Queue*) malloc(sizeof(Queue));
}

int QueueEnqueue(Queue *queue, int value){
	if (queue -> values == NULL){
		queue -> rear = 0;
		queue -> values = (int*) malloc(sizeof(int));	
	}

	(queue -> values)[queue->rear] = value;
	(queue -> rear)++;
	
	return 0;
}

int QueueDequeue(Queue* queue, int* value){
	if (queue -> rear <= 0){
		return 1;
	}
	*value = (queue -> values)[0];
	int i;
	for (i = 1; i < queue->rear; ++i)	{
		(queue -> values)[i-1] = (queue -> values)[i];
	}
	(queue -> rear)--;	

	return 0;

}

int QueuePeek(const Queue* queue, int* value){
	*value = (queue -> values)[queue->rear];

	return 0;
}