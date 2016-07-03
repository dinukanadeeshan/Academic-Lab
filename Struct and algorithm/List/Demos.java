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

interface List{
	public boolean add(Customer customer);
	public void add(int index, Customer customer);
	public void remove();
	public Customer remove(int index);
	public boolean remove(Customer customer);
	public Customer set(int index, Customer customer);
	public int size();
	public boolean contains(Customer customer);
	public boolean isEmpty();
	public Object[] toArray();
}

class LinkedList implements List{
	private Customer first=null;
	private Customer last=null;
	
	public boolean add(Customer customer){
		if(first==null){
			first = customer;
		}
		if(last!=null){
			last.next = customer;
		}
		last = customer;
		return true;
	}
	
	public void add(int index, Customer customer){
		int size = size();
		if(index>=size){
			throw new ArrayIndexOutOfBoundsException(index + " >=" + size);
		}
		Customer c1 = first;
		Customer c2 = null;
		for(int i=0;i<size;i++){
			if(i==index){
				Customer tem = c2.next;
				c2.next = customer;
				customer.next = c1;
				return;
			}
			c2 = c1;
			c1 = c1.next;
		}
	}
	
	public void remove(){
		first = first.next;
	}
	
	public Customer remove(int index){
		int size = size();
		if(index>=size){
			throw new ArrayIndexOutOfBoundsException(index + " >=" + size);
		}
		Customer c1 = first;
		Customer c2 = null;
		for(int i=0;i<size;i++){
			if(i==index){
				if(c2==null){
					first = c1.next;
					return c1;
				}
				if(c1.next==null){
					last = c2;
					Customer tem = c2.next;
					c2.next = null;
					return tem;
				}
				c2.next = c1.next;
				return c1;
			}
			c2 = c1;
			c1 = c1.next;
		}
		return null;
	}
	
	public boolean remove(Customer customer){
		Customer c = first;
		while(c!=null){
			if(c.equals(customer)){
				return true;
			}
			c = c.next;
		}
		return false;
	}
	
	public Customer set(int index, Customer customer){
		int size = size();
		if(index>=size){
			throw new ArrayIndexOutOfBoundsException(index + " >=" + size);
		}
		Customer c1 = first;
		Customer c2 = null;
		for(int i=0;i<size;i++){
			if(i==index){
				Customer tem = c1.next;
				Customer tem2 = c1;
				c1 = customer;
				c1.next = tem;
				c2.next = c1;
				return tem2;
			}
			c2 = c1;
			c1 = c1.next;
		}
		return null;
	}
	
	public int size(){
		int count=0;
		Customer c = first;
		while(c!=null){
			c = c.next;
			count++;
		}
		return count;
	}
	
	public boolean contains(Customer customer){
		Customer c = first;
		while(c!=null){
			if(c.equals(customer)){
				return true;
			}
			c = c.next;
		}
		return false;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public Object[] toArray(){
		int size = size();
		Object ob[] = new Object[size];
		Customer c = first;
		for(int i=0;i<size;i++){
			ob[i] = c;
			c = c.next;
		}
		return ob;
	}
}
class Demos{
	public static void main(String args[]){
		List list=new LinkedList();
		list.add(new Customer("Danapala"));
		list.add(new Customer("Gunapala"));
		list.add(new Customer("Somapala"));
		list.add(new Customer("Amarapala"));
		//list.printStack();	//prints [Amarapala,Somapala,Gunapala,Amarapala]
		//System.out.println();
		//list.remove();		
		//list.printStack();	//prints [Somapala,Gunapala,Amarapala]	
		java.util.Arrays.toString(list.toArray());
		System.out.println(list.size());
		list.add(2, new Customer("Supun"));
		java.util.Arrays.toString(list.toArray());
		System.out.println(list.size());
		//System.out.println("Size of the Queue is "+list.size());
	}
}	
