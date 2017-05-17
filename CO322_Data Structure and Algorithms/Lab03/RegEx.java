import java.util.*;
import java.util.regex.*;
import java.io.*;

public class RegEx {
	public static void main(String[] args)throws Exception {
		
		String fileName = args[0];	//Read the file name from command line arguments
		String regex = args[1];		//Read the regex pattern from command line arguments

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = null;
		int c=0;
		while ((line = br.readLine()) != null) {
			c++; //Count the no of words of file
		}
		br.close();

		br = new BufferedReader(new FileReader(fileName));

		String [] wordList = new String[c];

		int i=0;
		while ((line = br.readLine()) != null) {
			wordList[i] = line;
			i++; 
		}

		br.close();
		//System.out.println(c);
		SearchWord sw = new SearchWord(wordList);
		sw.printSearchedList(regex);
	}
}

//Create a class for search the words...
class SearchWord{

	private String[] wordList;
 	
 	private String pattern;

	public SearchWord(String [] wordList){
		this.wordList = wordList;
		
	}

	//There has used binary search like algorithm
	private void search(int start, int end){
		int mid = (int)((start + end) / 2);
		if(start > end) return;
		
		if(matches(wordList[mid], pattern)){
			System.out.println(wordList[mid]);
		
		}
		
		search(start, mid-1);
		search(mid+1, end);
	}

	private boolean matches(String word, String regex){
		char key[] = regex.toCharArray();
		char w[] = word.toCharArray();
		boolean found = false;
		for (int i = 0; i < w.length; i++) {
			found = false;
			for (int j = 0; j < key.length; j++) {
				if (w[i] == key[j]) {
					found = true;
					break;
				}
			}

			if (!found) {
				return false;
			}
		}

		return true;
	}

	public void printSearchedList(String regex){

		pattern = regex;
		search(0,wordList.length-1);


	}
}


/**
	Complexcity Analyse:

	Runtime complexcity :-
		* If 	no of words of files = N,
		* 		no of characters of word = Wi (i=0,1,2,3,4,5...,N)
		* 		no of characters of regex = n
		* 	Then searching complexity is 
		*		O(N * n * Wi)
		*
		* In there we don't need additional space beacause when the word matches with regex it just print. 
		* So there is no any space complexity...
*/
