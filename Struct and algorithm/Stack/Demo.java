class Stack{
	private int item;
	private Stack next;
	public Stack (int item){
		this.item = item;
	}
	
	public String toString(){
		return "[" + item + "]";
	}
	
	public boolean push(int item){
		Stack tem = new Stack(this.item);
		tem.next = next;
		next = tem;
		this.item = item;
		return true;
	}
	
	public void printStack(){
		Stack tem = this;
		while(tem!=null){
			System.out.println(tem);
			tem = tem.next;
		}
	}
	
	public boolean pop(){
		item = next.item;
		next = next.next;
		return true;
	}
	
	public int count(){
		int count = 1;
		Stack tem = next;
		while(tem!=null){
			tem = tem.next;
			count++;
		}
		return count;
	}
}

public class Demo{
	public static void main(String args[]){
		Stack myStack = new Stack(100);
		myStack.push(200);
		myStack.push(300);
		myStack.push(400);
		myStack.push(500);
		myStack.printStack();
		myStack.pop();
		System.out.println(myStack.count());
	}
}
