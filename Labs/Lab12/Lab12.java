
public class Lab12 {
	//due tomorrow friday 11:59pm
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create an array
		Integer[] list = {4,24,17,8,53,81,72,31};

		//call method
		bubbleSort(list);
		System.out.println("Bubble Sort: ");

		//print array
		for(int i = 0; i < list.length; i++){
			System.out.println(list[i] + " ");
		}
		System.out.println();

		System.out.println("Insertion Sort: ");

		insertionSort(list);
		for(int i = 0; i < list.length; i++){
			System.out.println(list[i] + " ");
		}
		System.out.println();

	}

	//1. (5 pts) Implement generic insertion sort

	public static <E extends Comparable<E>> void insertionSort(E[] list){

		for(int i = 1 ; i < list.length; i++){


			for(int j = i - 1; j > list.length; j--){
				if(list[j].compareTo(list[i]) > 0){
					list[j + 1] = list[j];
				}

				list[j + 1] = list[i];
			}
		}



	}



	//2. (5 pts) Implement generic bubble sort


	public static <E extends Comparable<E>> void bubbleSort(E[] list){

		//implement body
		//what would we compare this to

		for(int i = 1; i < list.length; i++){
			for(int j = 0; j < list.length - 1; j++){

				if(list[j].compareTo(list[j + 1]) > 0){
					E temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}


	}

}
