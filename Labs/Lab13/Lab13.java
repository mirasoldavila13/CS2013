
public class Lab13 {
	//due saturday 11:59pm
	public static void main(String[] args) {
		//create an array
		Integer[] array = {7,56,34,1,23,74,23,12,43,3};
		
		//call the method
		mergeSort(array);
		
	
}


	//1. (10 pts) Implement generic merge sort


	public static <E extends Comparable<E>> void mergeSort(E[] list){

				
		
		if(list.length > 1){
			
			int mid = list.length / 2;
			E[] firstHalf = (E[]) new Comparable[mid];
			System.arraycopy(list, 0, firstHalf, 0, mid);
			mergeSort(firstHalf);
			
			//second half
			E[] secondHalf = (E[]) new Comparable[list.length - mid];
			System.arraycopy(list, mid, secondHalf,0, list.length - mid);
			mergeSort(secondHalf);
			
			//merge both of then
			E[] temp = merge(firstHalf, secondHalf);
			
			System.arraycopy(temp, 0, list, 0, temp.length);
			System.out.println("Merge Sorted: ");
			for(E e: temp){
				System.out.println(e);
			}
			

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



	 
}
