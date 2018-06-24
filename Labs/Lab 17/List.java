import java.util.ListIterator; 
import java.util.ArrayList;

public class List {

	public static void main(String[] args) {
		new List();
	}
	
	public List(){
		String[] name = {"Bob", "Isai", "Jayko", "Gian", "Isai", "Juan"};
		MyList<String> list = new MyLinkedList<String>(name);
		System.out.println(list.contains("Isai"));
		System.out.println(list.get(3));
		System.out.println(list.lastIndexOf("Isai"));
		list.set(4, "Ben");
	}

}
