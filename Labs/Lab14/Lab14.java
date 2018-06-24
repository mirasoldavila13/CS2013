
public class Lab14 {

	//2 (5 pts) Implement generic quick sort


	public static <E extends Comparable<E>> void quickSort(E[] list){
		quickSort(list, 0, list.length - 1);
	}

	public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last){
		if(last > first){
			int pivotIndex =  partition(list,first,last);
			//recursive call
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
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
	public static void main(String[] args) {

		Integer[] list = {4,7,4,5,6,1,-4,7,18,14};
		//call method
		quickSort(list);
		//heapSort(list);
		for(int i = 0; i < list.length; i++){
			System.out.print(list[i] + " ");
		}

	}


}

//doesn't work

//1 (5 pts) Implement generic heap sort
//class HeapSort{
//	public static <E extends Comparable<E>> void heapSort(E[] list){
//		Heap<E> heap = new Heap<E>();
//		//add elements
//		for(int i = 0; i < list.length; i++){
//			heap.add(list[i]);
//		}
//		//remove elements
//		for(int i = list.length - 1; i >= 0; i--){
//			list[i] = heap.remove();
//		}
//	}
//	
//}




