package data_structures;

//import java.awt.List;

import data_structures.*;
public class Driver {
	public Driver(){
		LinearListADT<String> list = new LinearLinkedList<String>();
		list.addFirst("b");
		list.addFirst("a");
		list.addFirst("b");
		list.insert("add", 2);
		list.addLast("c");
		list.addLast("d");
		list.insert("e", 6);
		list.remove(2);
		list.remove("nothing");
	
		list.remove("b");
		
		//list.insert("1", 7);
		/*System.out.println(list.locate("e"));
		System.out.println(list.get(4));
		System.out.println(list.contains("no"));
		System.out.println("");
		*/
		for(Object E : list)
			System.out.println(E);
		
	}
	
		public static void main(String[] args) {
			new Driver();
			
			
		}

}

