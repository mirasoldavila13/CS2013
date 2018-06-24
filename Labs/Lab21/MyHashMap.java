import java.util.ArrayList;
import java.util.Set;
/*Implement MyMap using open addressing with linear probing.) 
 * Create a new concrete class that implements MyMap using open 
   addressing with linear probing. Use h(key) = key % size as the
   hash function, where size is the hash-table size. Initially, 
   the hash-table size is 4. The size is doubled whenever the load 
   factor exceeds the threshold(0.5)
 */
public class MyHashMap<K,V> implements MyMap<K,V>{
	//hash table size 4
	private static int INITIAL_CAPACITY = 4;
	private static int MAX_CAPACITY = 1 << 30;
	private int size = 0, capacity;
	private static float LOAD_FACTOR = 0.5f;
	private float loadFactorThreshold;
	//table
	ArrayList<MyMap.Entry<K, V>> table;
	public static void main(String[] args) {
		 MyMap<String, Integer> map = new MyHashMap();
	       map.put("Ashley", 21);
	       map.put("Harley", 41);
	       map.put("Andrew", 23);
	       map.put("Cynthia", 23);
	       map.put("Jayko", 54);
	       map.put("Abel", 54);
	       map.put("Joaquin", 75);
	       map.put("Jorge", 31);

	       System.out.println("Entries in map: " + map);

	       System.out.println("The age of Andrew is " +
	           map.get("Andrew"));

	       System.out.println("The age of Jorge is " +
	           map.get("Jorge"));

	       System.out.println("Is Joaquin in the map? " +
	           map.containsKey("Joaquin"));

	       System.out.println("Is Gabriel in the map? " +
	           map.containsKey("Gabriel"));

	       System.out.println("Is age 43 in the map? " +
	           map.containsValue(43));

	       System.out.println("Is age 21 in the map? " +
	           map.containsValue(21));

	       System.out.print("Keys in map: ");
	       for (String key : map.keySet()) {
	           System.out.print(key + " ");
	       }
	       System.out.println();

	       System.out.print("Values in map: ");
	       for (int value : map.values()) {
	           System.out.print(value + " ");
	       }
	       System.out.println();

	       map.remove("Joaquinn");
	       System.out.println("Entries in map " + map);

	       map.clear();
	       System.out.println("Entries in map " + map);
	   
	}
	
	public MyHashMap(){
		this(INITIAL_CAPACITY, LOAD_FACTOR);
	}
	
	public MyHashMap(int initialCapacity){
		this(initialCapacity, LOAD_FACTOR);
	}
	
	public MyHashMap(int initialCapacity, float loadFactorThreshold){
		if(initialCapacity > MAX_CAPACITY){
			this.capacity = MAX_CAPACITY;
		}
		else{
			this.capacity = trimToPowerOf2(initialCapacity);
			this.loadFactorThreshold = loadFactorThreshold;
			table = new ArrayList();
			for(int i = 0; i < capacity; i++){
				table.add(null);
			}
		}
	}

	@Override 
	public void clear() {
		size = 0;
		removeEntries();
		
	}

	@Override
	public boolean containsKey(K key) {
		if(get(key) != null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean containsValue(V value) {
		for(int i = 0; i < capacity; i++){
			if(table.get(i) != null && table.get(i).getValue() == value){
				return true;// if the map contains a value will return true
			}
		}
		return false;//if the map doesn't contain no value will return false
	}

	@Override
	public Set<MyMap.Entry<K, V>> entrySet() {
		java.util.Set<MyMap.Entry<K, V>> set = new java.util.HashSet();
		for(int i = 0; i < capacity; i++){
			if(table.get(i) != null){
				set.add(table.get(i));
			}
		}
		return set;// return set 
	}

	@Override
	public V get(K key) {
		int index = hash(key.hashCode());
		int i = 0;
		while(table.get(index) != null){
			if(table.get(index).getKey().equals(key)){
				return table.get(index).getValue();
			}
			index += Math.pow(i++, 2);
			index %= capacity;
		}
		return null;
	}

	@Override
	public Set<V> getAll(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}

	@Override
	public Set<K> keySet() {
		java.util.Set<K> set = new java.util.HashSet();
		for(int i = 0; i < capacity; i++){
			if(table.get(i) != null){
				set.add(table.get(i).getKey());
			}
		}
		return set;
	}

	@Override
	public V put(K key, V value) {
		int index = hash(key.hashCode());
		int i = 0;
		while(table.get(index) != null){
			//key is already in the map
			if(table.get(index).getKey().equals(key)){
				Entry<K, V> entry = table.get(index);
				V oldValue = entry.getValue();
				//swap old value with new value
				entry.value = value;
				table.set(index, entry);
				return oldValue;
			}
			index += Math.pow(i++, 2);
			index %= capacity;
		}
		//check load factor
		if(size >= (capacity * loadFactorThreshold)){
			if(capacity == MAX_CAPACITY){
				throw new RuntimeException("Exceeding maximum capacity");
			}
			rehash();
		}
		//add new entry to hashtable
		table.set(index, new MyMap.Entry<K, V>(key, value));
		size++;
		return value;
	}

	@Override
	public void remove(K key) {
		int index = hash(key.hashCode());
		int i = 0;
		//remove the first entry which matches the key
		while(table.get(index) != null){
			if(table.get(index).getKey().equals(key)){
				table.remove(index);
				size--;
				break;
			}
			index += Math.pow(i++, 2);
			index %= capacity;
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Set<V> values() {
		java.util.Set<V> set = new java.util.HashSet();
		for(int i = 0; i < capacity; i++){
			if(table.get(i) != null){
				set.add(table.get(i).getValue());
			}
		}
		return set;
	}
	
	//hash function
	private int hash(int hashCode){
		return supplementalHash(hashCode) & (capacity -1);
	}
	
	//hash is being distributed
	private static int supplementalHash(int h){
		h ^= ( h >>> 20) ^ (h >>> 12);
		return h ^( h >>> 7) ^ (h >>> 4);
	}
	
	
	private int trimToPowerOf2(int initialCapacity){
		int capacity = 1;
		while(capacity < initialCapacity){
			capacity <<= 1;
		}
		return capacity;
	}
	
	private void removeEntries(){
		table.clear();
	}
	
	private void rehash(){
		java.util.Set<Entry<K, V>> set = entrySet();
		capacity <<= 1;
		size = 0;
		table.clear();
		for(int i = 0; i < capacity; i++){
			table.add(null);
		}
		for(Entry<K, V> entry: set){
			put(entry.getKey(), entry.getValue());
		}
	}
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder("[");
		for(Entry<K, V> entry: table){
			if(entry != null && table.size() > 0){
				stringBuilder.append(entry);
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
