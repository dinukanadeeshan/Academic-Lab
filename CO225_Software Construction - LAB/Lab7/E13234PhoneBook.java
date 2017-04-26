import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.util.regex.Pattern;

public class E13234PhoneBook{
	
	public static void main(String[] args) {
		Map<String, Contact> contactList = new HashMap<>();

		try{
			BufferedReader br = new BufferedReader(new FileReader("./contacts.csv"));
			Scanner input = new Scanner(System.in);
			String line;
			while ((line = br.readLine()) != null) {
				
				String[] item = line.split(",");
				try{
					Contact contact = new Contact(Integer.parseInt(item[0]),item[1],item[2],item[3],item[4],item[5]);
					contactList.put(item[1]+" "+item[2], contact);
				}catch(NumberFormatException e){
					if(!e.getMessage().contains("id")){
						System.out.print(e.getMessage()+"\nDo you want to continue?(y/n):");
						if(input.next().equals("y")) return;

					}
				}
			}

			//BufferedInputStream bis = new BufferedInputStream(System.in);

			
			
			do{
				System.out.print("Enter name : ");
				try{
					String name = input.next();
					Iterator<String> iter = contactList.keySet().iterator();

					while(iter.hasNext()){
						String n = iter.next();
						if(n.contains(name)){
							System.out.println(contactList.get(n));
							//break;
						}
					}
				}catch(java.util.NoSuchElementException e){
					break;
				}

			}while(true);
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}
}

class Contact{
	private int id;
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
	private String company;


	public Contact(){}
	
	public Contact(int id, String first_name, String last_name, String phone, String email, String company){
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.company = company;
	}

	public void setId(int id){ this.id = id; }

	public void setFirstName(String first_name){ this.first_name = first_name; }

	public void setLastName(String last_name){ this.last_name = last_name; }

	public void setPhone(String phone){ this.phone = phone; }

	public void setEmail(String email){ this.email = email; }

	public void setCompany(String company){ this.company = company; }


	public int getId(){ return id;}

	public String getFirstName(){ return first_name;}

	public String getLastName(){ return last_name;}

	public String getPhone(){ return phone;}

	public String getEmail(){ return email;}

	public String getCompany(){ return company;}


	@Override
	public String toString(){
		return "\nFirst Name: "+first_name+"\nLast Name: "+last_name+"\nPhone: "+phone+"\nEmail: "+email
				+"\nCompany: "+company;
	}

}
