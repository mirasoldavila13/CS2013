import java.util.Scanner;



public class Recursion2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter a number:  ");
	double data = scan.nextDouble();
	System.out.println("The recursion is : " + harmonicSum(data));
	

	}
	
	public static double harmonicSum(double n){
		//implement body
		if(n == 1){
			return 1;
		}
		else{
			return 1/n + harmonicSum(n - 1);
		}

		}

}
