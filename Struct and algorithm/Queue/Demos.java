class Customer{
	String name;
	Customer next;
	Customer(String name){this.name=name;}
	public String toString(){
		return name;
	}
	public boolean equals(Object ob){
		if(ob instanceof Customer){
			Customer c = (Customer) ob;
			return name.equalsIgnoreCase(c.name);
		}
		return false;
	}
}
class Queue{
	private Customer front=null;
	private Customer rear=null;
	public boolean insert(Customer customer){
		if(front==null){
			front = customer;
		}
		if(rear!=null){
			rear.next = customer;
		}
		rear = customer;
		return true;
	}
	
	public void printStack(){
		Customer c = front;
		System.out.print("[");
		while(c!=null){
			System.out.print(c + ", ");
			c = c.next;
		}
		System.out.println("\b\b]");
	}
	
	public Customer remove(){
		Customer tem = front;
		if(front!=null){
			front = front.next;
		}
		return tem;
	}
	
	public int size(){
		Customer c = front;
		int count = 0;
		while(c!=null){
			c = c.next;
			count++;
		}
		return count;
	}
	
	public Customer searchCustomer(String name){
		Customer c = front;
		Customer eq = new Customer(name);
		while(c!=null){
			if(c.equals(eq)){
				return c;
			}
			c = c.next;
		}
		return null;
	}
	
	public Customer searchCustomer(Customer customer){
		Customer c = front;
		while(c!=null){
			if(c.equals(customer)){
				return c;
			}
			c = c.next;
		}
		return null;
	}
	
}
class Demos{
	public static void main(String args[]){
		Queue myStack=new Queue();
		myStack.insert(new Customer("Danapala"));
		myStack.insert(new Customer("Gunapala"));
		myStack.insert(new Customer("Somapala"));
		myStack.insert(new Customer("Amarapala"));
		myStack.printStack();	//prints [Amarapala,Somapala,Gunapala,Amarapala]
		System.out.println();
		myStack.remove();		
		myStack.printStack();	//prints [Somapala,Gunapala,Amarapala]	
		System.out.println();
		System.out.println("Size of the Queue is "+myStack.size());
	}
}	
