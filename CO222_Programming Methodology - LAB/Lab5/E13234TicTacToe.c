/*
	CO222-2016 Lab05
	Author: E13234

	TicTacToe game
*/
#include<stdio.h>
#include<stdlib.h>

#define SIZE 3

void scanBoard(int a[SIZE][SIZE]);
void printBoard(int b[SIZE][SIZE]);
int getWinner(int b[SIZE][SIZE]);

int main(){

	int inBoard[SIZE][SIZE];	//declaring an array

	printf("Please enter the board:\n");
	scanBoard(inBoard);	//scanBoard
	printf("Here is the board:\n");
	printBoard(inBoard);	//printBoard

	//printing the result
	if(getWinner(inBoard)==0)	
		printf("Noughts win\n");
	else if(getWinner(inBoard)==1)
		printf("Crosses win\n");
	else
		printf("There are no winners\n");
	
	return 0;
}


//scan function
void scanBoard(int board[SIZE][SIZE]){
	
	//check if the input is 0 || 1 || 2
	//else give the error message "Enter valid input." and terminate the program
	int i;
	for(i=0;i<SIZE;i++){
		int a,b,c;
		
		scanf("%d %d %d", &a,&b,&c);
		
	
		
		if(a != 0 && a!=1 && a!=2){
			puts("Enter valid input.");
			exit(1);
		}
		if(b != 0 && b!=1 && b!=2){
			puts("Enter valid input.");
			exit(1);
		}
		if(c != 0 && c!=1 && c!=2){
			puts("Enter valid input.");
			exit(1);
		}
		
		board[i][0] = a;
		board[i][1] = b;
		board[i][2] = c;
		
	}
	
	
}


//print function
void printBoard(int board[SIZE][SIZE]){
	//printing board
	int i;
	for(i = 0;i<SIZE;i++){
		int j;
		for(j=0;j<SIZE;j++){
			
			if(board[i][j] == 0){
				printf("O ");
			}else if(board[i][j] == 1){
				printf("X ");
			}else if(board[i][j] == 2){
				printf(". ");
			}
		}
		printf("\n");
	}
}


//find the winner of the game
//assume both two players can't win the game at the same time. It can't happen in a real game
int getWinner(int board[SIZE][SIZE]){
	
	int winner = 2;	
	
	//if winner is Noughts, winner = 0
	//if winner is Crosses, winner = 1
	//if there is no winner, winner = 2

	int i;
	for(i = 0;i<SIZE;i++){
		int isSame=1;
		int val;
		int j;
		for(j=1;j<SIZE;j++){
			val = board[i][j];
			if(isSame == 1){
				
				if(board[i][j-1] != board[i][j]){
					
					isSame = 0;
					break;
				}
			}
			if(isSame == 1 && j == SIZE - 1){
				winner = val;
				return  winner;
			}
			
		}
		
		
	}

	
	for(i = 0;i<SIZE;i++){
		int isSame=1;
		int val;
		int j;
		for(j=1;j<SIZE;j++){
			val = board[i][j];
			if(isSame == 1){
				if(board[j-1][i] != board[j][i]){
					isSame = 0;
					break;
				}
			}
			if(isSame == 1 && j == SIZE - 1){
				winner = val;
				return  winner;
			}
		}
		
		
	}
	int isSame = 1;
	for(i=1;i<SIZE;i++){
		
		int val;
		if(isSame == 1){
			val = board[i][i];
			if(board[i-1][i-1] != board[i][i]){
				isSame = 0;
				break;
			}
			
		}
		if(isSame == 1 && i == SIZE - 1){
			winner = val;
			return  winner;
		}
	}
	for(i = 0;i<SIZE;i++){
		isSame=1;
		int val;
		int j;
		for(j=SIZE;j>=0;j--){
			val = board[i][j];
			if(isSame == 1){
				if(board[i-1][j-1] != board[i][j]){
					isSame = 0;
					break;
				}
			}
			if(isSame == 1 && j == 0){
				winner = val;
				return  winner;
			}
			
		}
		
		
	}
	
	//~ if(board[0][0] == board[0][1] && board[0][1] == board[0][2]){
		//~ winner = board[0][0];
		//~ 
	//~ }else if(board[1][0] == board[1][1] && board[1][1] == board[1][2]){
		//~ winner = board[1][0];
	//~ }else if(board[2][0] == board[2][1] && board[2][1] == board[2][2]){
		//~ winner = board[2][0];
	//~ }else if(board[0][0] == board[1][0] && board[1][0] == board[2][0]){
		//~ winner = board[0][0];
	//~ }else if(board[0][1] == board[1][1] && board[1][1] == board[2][1]){
		//~ winner = board[0][1];
	//~ }else if(board[0][2] == board[1][2] && board[1][2] == board[2][2]){
		//~ winner = board[0][2];
	//~ }else if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
		//~ winner = board[0][0];
	//~ }else if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
		//~ winner = board[0][2];
	//~ }

	return  winner;
}


 
