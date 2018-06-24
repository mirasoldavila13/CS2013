/* (5 pts) Rewrite recursive selection sort to non-recursive selection sort.
	(5 pts) Rewrite recursive binary search to non-recursive binary search.
*/
public class Lab05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {9,5,18,305,113,4,212,8,12,6};// create an array
		//print out array to test that it isn't in order
//		System.out.print("The current array : -\n");
//		for(int i: array){
//			System.out.println(i);
//		}
//		System.out.println();
		
		
		 sort(array);//call method
		 System.out.println();
		 System.out.println("Binary Search: \n");
		 binarySearch(array, 0);
		
		
	}
	
	//recursive selection sort to non-recursive selection sort, don't return anything since we have the object
	//create loops

	public static void sort(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			int min = array[i];
			int minIndex = i;
			for(int j = i +1; j < array.length; j++){
				//swap
				if(min > array[j]){
					min = array[j];
					minIndex = j;
				}
			}
			
			if(minIndex != i){
				array[minIndex] = array[i];
				array[i] = min;
			}
		}
		System.out.print("Selection sort: \n");
		for(int i: array){
			System.out.println(i);
		}
		
		
	}
	
	//recursive binary search to non-recursive binary search
	// think of it already being in order?
	public static void binarySearch(int[] array, int key){
		int high = array.length - 1;
		int low = 0;
		
		//while loop
		while(high >= low){
			int mid = (low + high) / 2;
			if(key < array[mid]){
				System.out.println(high = mid - 1);
			}
			else if( key == array[mid]){
				System.out.println(mid);
			}
			else{
				System.out.println(low = mid + 1);
			}
			
		System.out.println(-low - 1);
		
	}
  }
}
