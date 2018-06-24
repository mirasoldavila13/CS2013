
import java.util.Scanner;

public class PatternMatching {
	public static int matchStr(String str1, String str2){
		
		for(int i = 0; i < str1.length(); i++){
			int k = 0;
			for(int j = i; j < str1.length(); j++){
				if(k == str2.length()){
					//return length of str2
					return (j - str2.length());
				}
				else{
					if(str1.charAt(i) == str2.charAt(k)){
						k++;//increase k
					}
					else{
						break;//don't want an infite loop 
					}
					
				}
			}
			
		}
		return 0;
	}
	public static void main(String[] args) {
		String string1, string2;
		// Scanner
		Scanner input = new Scanner(System.in);
		//let user enter first string
		System.out.println("Enter first string");
		string1 = input.nextLine();
		//let user enter second string. the first and second string are the two inputs
		System.out.println("Enter second string");
		string2 = input.next();
		//call the matchStr method
		int str = matchStr(string1, string2);//its not doing anything
		//str doesn't equal 0
		if(str != 0){
			System.out.println("Matched at index " + str);
		}
		else{
			System.out.println("There is no matched index");
		}
	}
	
}
