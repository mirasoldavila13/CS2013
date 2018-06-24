/* 
Write a program that obtains the execution time of insertion sort, bubble sort, selection sort, merge sort, quick sort, 
and heap sort for input size 50000, 100,000, 150,000, 200,000, 250,000, and 300,000. Your program should create data randomly
and print a table like this: (Option: if it is too difficult to generate the table, you can use a text editor creating a table 
and fill out execution time.) */

public class HW08 {

	public static void main(String[] args) {
		//eclapse time
		long startTime = 0, endTime = 0;
		//doesn't run
		//insertion sort
		Integer[][] insertionSort = new Integer[6][];
		insertionSort[0] = new Integer[50000];
		insertionSort[1] = new Integer[100000];
		insertionSort[2] = new Integer[150000];
		insertionSort[3] = new Integer[200000];
		insertionSort[4] = new Integer[250000];
		insertionSort[5] = new Integer[300000];
		//bubble sort
		Integer[][] bubbleSort = new Integer[6][];
		bubbleSort[0] = new Integer[50000];
		bubbleSort[1] = new Integer[100000];
		bubbleSort[2] = new Integer[150000];
		bubbleSort[3] = new Integer[200000];
		bubbleSort[4] = new Integer[250000];
		bubbleSort[5] = new Integer[300000];
		//selection sort
		Integer[][] selectionSort = new Integer[6][];
		selectionSort[0] = new Integer[50000];
		selectionSort[1] = new Integer[100000];
		selectionSort[2] = new Integer[150000];
		selectionSort[3] = new Integer[200000];
		selectionSort[4] = new Integer[250000];
		selectionSort[5] = new Integer[300000];
		//merge sort
		Integer[][] mergeSort = new Integer[6][];
		mergeSort[0] = new Integer[50000];
		mergeSort[1] = new Integer[100000];
		mergeSort[2] = new Integer[150000];
		mergeSort[3] = new Integer[200000];
		mergeSort[4] = new Integer[250000];
		mergeSort[5] = new Integer[300000];
		//quick sort
		Integer[][] quickSort = new Integer[6][];
		quickSort[0] = new Integer[50000];
		quickSort[1] = new Integer[100000];
		quickSort[2] = new Integer[150000];
		quickSort[3] = new Integer[200000];
		quickSort[4] = new Integer[250000];
		quickSort[5] = new Integer[300000];
		//heap sort
		Integer[][] heapSort = new Integer[6][];
		heapSort[0] = new Integer[50000];
		heapSort[1] = new Integer[100000];
		heapSort[2] = new Integer[150000];
		heapSort[3] = new Integer[200000];
		heapSort[4] = new Integer[250000];
		heapSort[5] = new Integer[300000];
		//insertion,bubble,selection,merge,quick and heap elapsed time 
		long[] insertionExecutionTime = new long[6];
		long[] bubbleExecutionTime = new long[6];
		long[] selectionExecutionTime = new long[6];
		long[] mergeExecutionTime = new long[6];
		long[] quickExecutionTime = new long[6];
		long[] heapExecutionTime = new long[6];
	
		//randomly store each array
		for(int i = 0; i < selectionSort.length; i++){
			for(int j = 0; j < selectionSort[i].length; j++){
				int num = (int)(Math.random()) * 1000;
				insertionSort[i][j] = num;
				bubbleSort[i][j] = num;
				selectionSort[i][j] = num;
				mergeSort[i][j] = num;
				quickSort[i][j] = num;
				heapSort[i][j] = num;
			}
		}
		
		//find elapsed time for insertion sort
		for(int i = 0; i < insertionSort.length; i++){
			startTime = System.currentTimeMillis();
			//call insertion sort method
			insertion(insertionSort[i]);
			endTime = System.currentTimeMillis();
			selectionExecutionTime[i] = endTime - startTime;
			startTime = 0;
			endTime = 0;
		}
		//find the elapse time for bubble sort
		for(int i = 0; i < bubbleSort.length; i++){
			startTime = System.currentTimeMillis();
			//call bubble sort method
			bubble(bubbleSort[i]);
			endTime = System.currentTimeMillis();
			selectionExecutionTime[i] = endTime - startTime;
			startTime = 0;
			endTime = 0;
		}
		//find the elaspsed time for selection sort
		for(int i = 0; i < selectionSort.length; i++){
			startTime = System.currentTimeMillis();
			//call selection sort method
			selection(selectionSort[i]);
			endTime = System.currentTimeMillis();
			selectionExecutionTime[i] = endTime - startTime;
			startTime = 0;
			endTime = 0;
		}
		//find the elaspsed time for merge sort
		for(int i = 0; i < mergeSort.length; i++){
			startTime = System.currentTimeMillis();
			//call merge sort method
			merge(mergeSort[i]);
			endTime = System.currentTimeMillis();
			selectionExecutionTime[i] = endTime - startTime;
			startTime = 0;
			endTime = 0;
		}
		//find elapsed time for quick sort
		for(int i = 0; i < quickSort.length; i++){
			startTime = System.currentTimeMillis();
			//call quick sort method
			quick(quickSort[i]);
			endTime = System.currentTimeMillis();
			selectionExecutionTime[i] = endTime - startTime;
			startTime = 0;
			endTime = 0;
		}
		//find elapsed time for heap sort
		for(int i = 0; i < heapSort.length; i++){
			startTime = System.currentTimeMillis();
			//call quick sort method
			heap(heapSort[i]);
			endTime = System.currentTimeMillis();
			selectionExecutionTime[i] = endTime - startTime;
			startTime = 0;
			endTime = 0;
		}
		

System.out.printf("%10s", "Array Size", "|", "Insertion Sort", "Bubble Sort", "Selection Sort", "Merge Sort", "Quick Sort", "Heap Sort");
System.out.println("-----------|------------------------------------------------------------------------------------------------------------------------------------");

for(int i = 0; i < selectionSort.length; i++){
	System.out.printf("%7s", selectionSort[i].length, "|", insertionExecutionTime[i], bubbleExecutionTime[i], selectionExecutionTime[i], mergeExecutionTime[i], quickExecutionTime[i], heapExecutionTime[i]);

}
	}
	//create insertion method
	public static <E extends Comparable<E>> void insertion(E[] list){
		E temp = list[0];
		for(int i = 0; i < list.length; i++){
			for(int j = i; j > 0; j--){
				if(list[j].compareTo(list[j - 1]) < 0){
					 temp = list[j];
					 list[j] = list[j - 1];
					 list[j - 1] = temp;
				}
			}
		}
		
	}
	//create bubble sort method
	public static <E extends Comparable<E>> void bubble(E[] list){
		E temp = list[0];
		for(int i = 1; i < list.length; i++){
			for(int j = 0; j < list.length - 1; j++){

				if(list[j].compareTo(list[j + 1]) > 0){
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
	}
	//create selection sort method
	public static <E extends Comparable<E>> void selection(E[] list){
		for (int i = 0; i < list.length - 1; ++i)
	    {
	      int minIndex = i;
	      for (int j = i + 1; j < list.length; ++j)
	      {
	        if (list[j].compareTo(list[minIndex]) < 0)
	        {
	          minIndex = j;
	        }
	      }
	      // String changed to E
	      E temp = list[i];
	      list[i] = list[minIndex];
	      list[minIndex] = temp;
	    }
	    
	}
	//create merge sort method
	public static <E extends Comparable<E>> void merge(E[] list){

		if(list.length > 1){
			
			int mid = list.length / 2;
			E[] firstHalf = (E[]) new Comparable[mid];
			System.arraycopy(list, 0, firstHalf, 0, mid);
			merge(firstHalf);
			
			//second half
			E[] secondHalf = (E[]) new Comparable[list.length - mid];
			System.arraycopy(list, mid, secondHalf,0, list.length - mid);
			merge(secondHalf);
			
			//merge both of then
			E[] temp = merge(firstHalf, secondHalf);
			
			System.arraycopy(temp, 0, list, 0, temp.length);
		}
			
	}
		public static<E extends Comparable<E>> E[] merge(E[] firstHalf, E[] secondHalf){
			E[] temp = (E[]) new Comparable[firstHalf.length + secondHalf.length];
			
			//list1 current index
			int current1 = 0;
			//list2 current index
			int current2 = 0;
			//temp current index
			int current3 = 0;
			
			while(current1 < firstHalf.length && current2 < secondHalf.length){
				if(firstHalf[current1].compareTo(secondHalf[current2]) < 0){
					temp[current3++] = firstHalf[current1++];
				}
				else{
					temp[current3++] = secondHalf[current2++];
				}
			}
			while(current1 < firstHalf.length){
				temp[current3++] = firstHalf[current1++];
			}
			while(current2 < secondHalf.length){
				temp[current3++] = secondHalf[current2++];
			}
			return temp;
		}
	//create quick sort method
	public static <E extends Comparable <E>>void quick(E[] list){
		quick(list, 0, list.length - 1);
	}
	public static <E extends Comparable<E>> void quick(E[] list, int first, int last){
		if(last > first){
			int pivotIndex =  partition(list,first,last);
			//recursive call
			quick(list, first, pivotIndex - 1);
			quick(list, pivotIndex + 1, last);
		}
	}

	private static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
		// TODO Auto-generated method stub
		E pivot = list[first];
		int low = first + 1;
		int high = last;

		while(high > low){
			//search the left side
			while( low <= high && list[low].compareTo(pivot) <= 0){
				low++;
			}
			//search from the right
			while(low <= high && list[high].compareTo(pivot) > 0){
				high--;

			}
			//swap two elements within the list
			if(high > low){
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while(high > first && list[high].compareTo(pivot) >= 0)
			high--;

		//swap pivot with list[high]
		if(pivot.compareTo(list[high]) > 0){
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else{
			return first;
		}
	}


	public static <E extends Comparable> void heap(E[] list){
		//Heap<E> heap = new Heap<E>;
	}
}
