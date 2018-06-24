import java.util.Scanner;


public class Recursion1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a first number:  ");
		double base = scan.nextDouble();
		System.out.print("Enter second  number:");
		int exponent = scan.nextInt();
		System.out.println("The recursion is : " + powerN(base, exponent));

	}
	public static double powerN(double x, int y){
		
		if(y == 1){
			return x;
		}
		else{
			
			return x * (powerN(x, y-1)) ;
		}
		

		//implement body

		}

}
