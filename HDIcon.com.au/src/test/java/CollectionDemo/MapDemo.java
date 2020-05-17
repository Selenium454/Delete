package CollectionDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
	
	public static void hashMapDemo() {
		HashMap<Integer, String> hm =new HashMap<Integer, String>();
		hm.put(101, "Johnson");
		hm.put(100, "Smith");
		hm.put(100, "John");
		
		
		System.out.println(hm);
		
		for (Map.Entry<Integer, String> element : hm.entrySet()) {
			System.out.println("Key:" +element.getKey()+ " Value: " +element.getValue());
			
		}
		
		Set<Map.Entry<Integer, String>> element =hm.entrySet();
		Iterator i= element.iterator();
		while(i.hasNext()) {
			Map.Entry<Integer, String> entry =(Map.Entry<Integer, String>)i.next();
			System.out.println("Key:"+entry.getKey()+"Value"+entry.getValue());
		}
		
	}
	public static void LinkedHashMapDemo() {
		LinkedHashMap<Integer, String> hm =new LinkedHashMap<Integer, String>();
		hm.put(101, "Johnson");
		hm.put(100, "Smith");
		hm.put(100, "John");
		
		System.out.println(hm);
	}

	public static void TreeMapDemo() {
		TreeMap<Integer, String> hm =new TreeMap<Integer, String>();
		hm.put(101, "Johnson");
		hm.put(100, "Smith");
		hm.put(100, "John");
		
		System.out.println(hm);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hashMapDemo();
		//LinkedHashMapDemo();
		//TreeMapDemo();
	}

}
