package CollectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class ListDemo {
	
	//Retrive value for AL
	//\it accept multi thread
	public static void arrayListDemo() {
		ArrayList<Integer> al =new ArrayList<Integer>();
		al.add(30);
		al.add(20);
		al.add(null);
		al.add(null);
		al.add(20);
		
		System.out.println(al);//30 20 null null 20
		
		System.out.println(al.get(3));
		
		for (Integer val : al) {
		System.out.println(val);	
		}
		
		//enumarator 
		//iterator
		//list iterator
		
		Iterator i=al.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		}
	
	//When adding value at middle
	public static void linkedListDemo() {
		LinkedList al =new LinkedList();
		al.add(30);
		al.add(20);
		al.add(null);
		System.out.println(al);//30 20 null
		System.out.println(al.size());
	}
	
	//only one thread can access at time
	public static void vectorDemo() {
		Vector al =new Vector();
		al.add(30);
		al.add(20);
		al.add(null);
		System.out.println(al);//30 20 null
	}
	// First in Last out machnisam
	public static void stackDemo() {
		Stack al =new Stack();
		al.add(30);
		al.add(20);
		al.add(null);
		System.out.println(al);//30 20 null
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arrayListDemo();
		//linkedListDemo();
		//vectorDemo();
		//stackDemo();
	}

}
