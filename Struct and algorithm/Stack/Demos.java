class Customer{
	String name;
	Customer next;
	Customer(String name){this.name=name;}
	public String toString(){
		return name;
	}
}
class Stack{
	Customer customerStack=null;
	public boolean push(Customer customer){
		customer.next = customerStack;
		customerStack = customer;
		return true;
	}
	
	public void printStack(){
		Customer c = customerStack;
		System.out.print("[");
		while(c!=null){
			System.out.print(c + ", ");
			c = c.next;
		}
		System.out.println("\b\b]");
	}
	
	public Customer pop(){
		if(customerStack!=null){
			Customer tem = customerStack;
			customerStack = customerStack.next;
			return tem;
		}else{
			return null;
		}
	}
	
	public int size(){
		Customer c = customerStack;
		int count = 0;
		while(c!=null){
			c = c.next;
			count++;
		}
		return count;
	}
	
}
class Demos{
	public static void main(String args[]){
		Stack myStack=new Stack();
		myStack.push(new Customer("Danapala"));
		myStack.push(new Customer("Gunapala"));
		myStack.push(new Customer("Somapala"));
		myStack.push(new Customer("Amarapala"));
		myStack.printStack();	//prints [Amarapala,Somapala,Gunapala,Amarapala]
		System.out.println();
		myStack.pop();		
		myStack.printStack();	//prints [Somapala,Gunapala,Amarapala]	
		System.out.println();
		System.out.println("Size of the Stack is "+myStack.size());
	}
}	
