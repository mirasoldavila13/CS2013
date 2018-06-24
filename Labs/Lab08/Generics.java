import java.util.ArrayList;

public class Generics {

	public static void main(String[] args) {
		// create an array list
		ArrayList list = new ArrayList();
		list.add(34);
		list.add(43);
		list.add(87);
		list.add(66);
		list.add(56);
		list.add(23);
		list.add(23);
		list.add(56);
		list.add(46);
		list.add(87);
		list.add(23);
		
		//create a 2d array
		Integer[][] num = {{3, 7, 4},{2, 5, 5}};
		
		//display
		System.out.println("The Array List: ");
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i) + " ");
		}
		
		//call the removeDepluicates method
		//create another arraylist
		ArrayList intArray = removeDuplicates(list);
		
		System.out.println();
		System.out.println();
		//display the new array list
		System.out.println("The new Array List with out duplicates: ");
		
		for(int i = 0; i < intArray.size(); i++){
			System.out.print(intArray.get(i) + " ");
		}
		System.out.println();
		System.out.println();
		//display 2d array output
		
		System.out.println("Max element of 2D array: " + max(num));
		System.out.println();
		
		System.out.println("Before the sorted array: ");
		//before sorting the array
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		//call sort method
		sort(list);
		System.out.println();
		System.out.println("Shuffle list are: ");
		suffle(list);
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i) + " ");
		}
		
		
	}
	//(2.5pts) implement the following method that returns a new ArryList which contains the non-duplicate elements from the original list.

	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		for(int i = 0; i < list.size(); i++ ){
			for(int j = 0; j < list.size(); j++){
				if( i == j){
					continue;
				}
				else if(list.get(i) == list.get(j)){
					list.remove(j);
				}
			}
		}
		return list;

	}

	//2) (2.5 pts) implement the method returns largest element from the two dimensional array

	public static <E extends Comparable<E>> E max(E[][] list){
	
		E max = list[0][0];
		//double loop
		for( int i = 1; i < list.length; i++){
			for( int j = 1; j < list[i].length; j++){
				//compare max 
				if(max.compareTo(list[i][j]) < 0){
					max = list[i][j];
				}
			}
		}
		return max;
	}

	//3) (2.5pts) implement a method that sorts an ArrayList

	public static <E extends Comparable<E>> void sort(ArrayList<E> list){
		E temp1;
		E temp2;//some reason this doesn't work
		
		
		for(int i = 0; i <list.size(); i++){
			for(int j = i + 1; j < list.size(); j++){
				if(list.get(i).compareTo(list.get(j)) > 0){
					temp1 = list.get(i);
					temp1 = list.get(j);
					
					list.remove(i);
//					
//					list.add(i, temp2); this doensn't work temp2 says it has to be null but doesn't seem right
					
					list.remove(j);
					
					list.add(j,temp1);
				}
			}
		}
		System.out.println();
		System.out.println("The Sorted list: ");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i) + " ");
		}
		System.out.println();
	}

	//4) (2.5pts) implement a method that shuffle an ArrayList

	public static <E > void suffle(ArrayList<E> list) {
		
		for(int i = 0; i < list.size() - 1; i++){
			int index = (int)(Math.random() * list.size());
			E temp = list.get(i);
			list.set(index,  list.get(index));
			list.set(index, temp);
		}
	}

}
