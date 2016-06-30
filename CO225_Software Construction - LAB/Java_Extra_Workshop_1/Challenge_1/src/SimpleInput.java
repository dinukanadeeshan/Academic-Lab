import java.util.Scanner;

/**
*	Author	: Mohammed Fawzan <fawzanm@gmail.com>
*	Program : Awkwardness
*	Date  	: 17/06/2016
* 	Desc	: Simple Program to get user inputs.
*/

//a class definition, Note that the FileName matches the ClassName
public class SimpleInput{

	
	public static void main(String[] args){
		
		String name;
		String age;

		Scanner input = new Scanner(System.in);

		System.out.println("What is your name?");
		name = input.next();

		System.out.println("How old are you?");
		age = input.next();

		System.out.println("Hi " + name + " So you are " + age + " Years old?");

	}


}
//end of the program

