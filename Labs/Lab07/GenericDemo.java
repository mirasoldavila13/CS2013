
public class GenericDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericStack<String> sgs = new GenericStack<>();//only can pass string if you pass anothe type there would be a runtime error
		sgs.push("Fun!");
		sgs.push("is");// push three strings on to our stack
		sgs.push("Java");
		
		while(!sgs.isEmpty()){
			System.out.println(sgs.pop() + " ");// then pop them up one at a time  until stack is empty 
		}
		
		GenericStack<Integer> igs = new GenericStack<>();//only can push integers 
		
		igs.push(876);
		igs.push(256);
		igs.push(345);
		
		while(!igs.isEmpty()){
			System.out.println(igs.pop() + " ");
		}
		
		
		//create an integer array
		Integer[] array = {3,45,66,33,4,556,32,456,76};
		selectionSort(array);
		
		//create an String array
		String[] sArray = {"pi", "cat", "eat", "dog"};
		
		int b = binarySearch(sArray, "e");
		int l = linearSearch(sArray, "d");
		
	
		
		//display the sorted arrays
		System.out.println();
		System.out.println("Selection sorted objects: ");
		printList(array);
		System.out.println();
		
		System.out.println("Binary Search: " + b);
		System.out.println("Linear Search: " + l);
		
		
		
		
		
	}

	//Implement the following generic method for linear search.

	public static <E extends Comparable<E>> int linearSearch(E[] list, E key){
		E min = list[0];
		int minIndex = 0;
		
		for(int i = 0; i < list.length - 1; i++){
			min = list[i];
			minIndex = i;
			
			for(int j = i + 1; j < list.length; j++){
				if(min.compareTo(list[j]) > 0){
					min = list[j];
					minIndex = j;
				}
				
			}

			}
		return minIndex;
		}
		
	

	//Implement the following generic method for binary search

	public static <E extends Comparable<E>> int binarySearch(E[] list, E key){
		int high = list.length - 1;
		int mid, low = 0;
		
		while(low <= high){
			mid = (low + high) / 2;
			
			if(key.compareTo(list[mid]) == 0){
				return mid;
			}
			else if(key.compareTo(list[mid]) < 0){
				high = mid - low;
			}
			else{
				low = mid + low;
			}
		}
		return -low - low;
		

	}
	//Implement the following generic method for selection sort

	public static<E extends Comparable<E>> void selectionSort(E[] list){
		E min = list[0];
		int minIndex = 0;
		
		for(int i = 0; i < list.length - 1; i++){
			min = list[i];
			minIndex = i;
			
			for(int j = i + 1; j < list.length; j++){
				if(min.compareTo(list[j]) > 0){
					min = list[j];
					minIndex = j;
				}
				
			}
			
			//swap
			if(minIndex != i){
				list[minIndex] = list[i];
				list[i] = min;
			}
		}
		
	}
	
	//print array 
	public static void printList(Object[] list){
		for(int i = 0; i < list.length; i++){
			System.out.println(list[i] + " ");
		}
	}

}
