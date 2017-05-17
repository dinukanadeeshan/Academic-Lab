import java.util.*;
import java.util.regex.*;
import java.io.*;

public class RegEx {
	public static void main(String[] args)throws Exception {
		ArrayList<String> lst = new ArrayList<>(); //Create the arraylist to store the data of file (Words list)
		
		String fileName = args[0];	//Read the file name from command line arguments
		String regex = args[1];		//Read the regex pattern from command line arguments

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = null;
		int c=0;
		while ((line = br.readLine()) != null) {
			lst.add(line);	//Read line by line from txt file and add to the array list
			c++;
		}
		br.close();
		//System.out.println(c);
		SearchWord sw = new SearchWord(lst);
		ArrayList<String> sl = sw.getSearchedList("[["+regex+"]+]+");	//Create the regex pattern
		System.out.println(Arrays.toString(sl.toArray()));	//Print the searched text matching words
	}
}

//Create a class for search the words...
class SearchWord{
	private ArrayList<String> selectedList;

	private ArrayList<String> wordList;
 	
 	private Pattern p;

 	private Matcher m;

	public SearchWord(ArrayList<String> wordList){
		this.wordList = wordList;
		
	}

	//There has used binary search like algorithm
	private void search(int start, int end){
		int mid = (int)((start + end) / 2);
		if(start > end) return;
		
		if(p.matcher(wordList.get(mid)).matches()){
			selectedList.add(wordList.get(mid));
		
		}
		
		search(start, mid-1);
		search(mid+1, end);
	}

	public ArrayList<String> getSearchedList(String regex){

		this.selectedList = new ArrayList<>();
		p = Pattern.compile(regex);

		search(0,wordList.size()-1);

		return selectedList;

	}
}