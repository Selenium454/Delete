package CollectionDemo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {

	//It's won't follow insertion order
	//not allowed duplicates
	public static void hashSetDemo() {
		HashSet<String> hs=new HashSet<String>();
		hs.add("One");
		hs.add("null");
		hs.add("One");
		hs.add("five");
		hs.add("two");
		
		System.out.println(hs);
	}
	
	//It's follow insertion order
	//not allowed duplicates
	public static void linkedHashSetDemo() {
		LinkedHashSet<String> hs=new LinkedHashSet<String>();
		hs.add("One");
		hs.add("null");
		hs.add("One");
		hs.add("five");
		hs.add("two");
		
		System.out.println(hs);
	}
	
	//Assending order
	public static void treeSetDemo() {
		TreeSet<String> hs=new TreeSet<String>();
		hs.add("one");
		hs.add("three");
		hs.add("four");
		hs.add("five");
		hs.add("six");
		
		System.out.println(hs);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hashSetDemo();
		linkedHashSetDemo();
		treeSetDemo();
	}

}
