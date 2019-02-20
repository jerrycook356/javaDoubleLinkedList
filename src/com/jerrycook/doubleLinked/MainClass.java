package com.jerrycook.doubleLinked;

public class MainClass {
	
	public static void main(String[] args) {
		
		DoubleLinked<Integer> dl = new DoubleLinked<Integer>();
		
		dl.addNode(1);
		dl.addNode(2);
		dl.addNode(3);
		dl.addNode(4);
		dl.addNode(5);
		
		printList(dl);
		
		dl.addNodeLast(6);
		printList(dl);
		
		dl.addNodeAt(10,4);
		System.out.println("after add 10 at position 4 ");
		printList(dl);
		
		System.out.println("add not at last position ");
		dl.addNodeAt(20, 6);
		printList(dl);
		System.out.println("add node as end");
		dl.addNodeAt(40,8);
		printList(dl);
		
		System.out.println("delete first");
		dl.deleteFirst();
		printList(dl);
		
		System.out.println("delete last");
		dl.deleteLast();
		printList(dl);
		
		System.out.println("delete at second ");
		dl.deleteAt(1);
		printList(dl);
		
		System.out.println("deleter at four");
		dl.deleteAt(4);
		printList(dl);
	}
	
	
	public static void printList(DoubleLinked<Integer> dl) {
		
		for(int i = 0; i < dl.getCount();i++) {
			
			System.out.print(dl.getAt(i).getValue()+" ");
		}
		System.out.println();
		System.out.println();
	}

}
