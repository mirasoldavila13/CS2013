


public class ReverseDisplay {

	public static void main(String[] args) {
		reverseDisplay(1234);
		System.out.println();
		String str = "Hello World";
		String reverse = reverseDisplay(str);
		System.out.println(reverse);


	}
	public static void reverseDisplay(int value){

		if(value == 0){
			return;
		}
		else{                       
			System.out.print(value % 10 );
			reverseDisplay(value / 10 );


		}

	}
	public static String reverseDisplay(String s){

		if(s.length() == 0){
			return s;
		}
		else{
			return reverseDisplay(s.substring(1)) + s.charAt(0); // hello world , ello world + h, llo world + e+ h, lo world + l + e + h, -> so on

		}
	}

}
