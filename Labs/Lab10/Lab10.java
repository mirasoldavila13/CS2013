import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
/* 1) (5 pts) Write a program that reads unspecified number of words from user input and
 *  display all words in the inserted order.

2) (5 pts) Write a program that reads unspecified number of words from user input and 
displays all the non-duplicate words in ascending order.
*/ 
public class Lab10 {

	public static void main(String[] args) {
		//create scanner
		Scanner in = new Scanner(System.in);
		//non-duplicate ascending order set
		TreeSet<String> treeset = new TreeSet<String>();
		//inserted order set
		LinkedHashSet<String> linkedset = new LinkedHashSet<>();
		
		System.out.println("Please enter words and end with \"end\"");
		while(in.hasNext()){
			String temp = in.next();
			if(temp.equals("end")){
				break;
			}
			else{
				treeset.add(temp);
				linkedset.add(temp);
			}
		}
		//iterate ascending order
		Iterator tSet = treeset.iterator();
		//ascending oder
		System.out.println("Ascending order: ");
		while(tSet.hasNext()){
			System.out.print(tSet.next() + " ");
		}
		System.out.println();
		
		//iterate inserted order
		Iterator lSet = linkedset.iterator();
		System.out.println("Inserted order: ");
		while(lSet.hasNext()){
			System.out.print(lSet.next() + " ");
		}
		System.out.println();
		
		
	}
	
	
	

}
