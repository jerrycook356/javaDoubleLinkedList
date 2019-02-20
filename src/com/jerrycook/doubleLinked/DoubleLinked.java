package com.jerrycook.doubleLinked;

public class DoubleLinked<NodeType> {

	
	private Node<NodeType> root;
	private Node<NodeType> tail;
	private int count;
	
	public DoubleLinked() {
		root = null;
		tail = null;
	}
	
	
	public int getCount() {
		return count;
	}
	public Node<NodeType> getAt(int index){
		
		index = index > count ? count:index;
		if( index  <= 0) {
			return root;
		}
		
		Node<NodeType> tempNode = root;
		for(int i = 0; i < index ; i++) {
			tempNode = tempNode.getNext();
		}
		return tempNode;
		
	}
	
	//adds node at the front of the list
	public void addNode(NodeType value) {
		Node<NodeType> newNode = new Node<NodeType>(value);
		
		if(root == null) {
			root = newNode;
			root.setPrev(null);
			root.setNext(null);
			
		}else {
			Node<NodeType> tempNode = root;
			root = newNode;
			tempNode.setPrev(root);
			root.setNext(tempNode);
			tail = tempNode;
		}
		
		count++;
		
	}
	
	//add node to the end of the list
	public void addNodeLast(NodeType value) {
		Node<NodeType> newNode = new Node<NodeType>(value);
		Node<NodeType> tempNode = root;
		for(int i = 0; i < count-1; i ++) {
			tempNode = tempNode.getNext();
		}
		tempNode.setNext(newNode);
		tail = newNode;
		newNode.setPrev(tempNode);
		count++;
	}
	
	public void addNodeAt(NodeType value, int position) {
		Node<NodeType> newNode = new Node<NodeType>(value);
		Node<NodeType> tempNode = root;
		if(position <= 0) {
			addNode(value);
			return;
		}else if(position >= count){
			addNodeLast(value);
			return;
		}else if (position < (count /2)){
		
			for(int i = 0; i < position -1; i++) {
				tempNode = tempNode.getNext();
			}
			Node<NodeType> switchNode = tempNode.getNext();
			tempNode.setNext(newNode);
			newNode.setPrev(tempNode);
			switchNode.setPrev(newNode);
			newNode.setNext(switchNode);
			
		}else if ( position > (count /2)) {
			tempNode = tail;
			for(int i = count; i > position+1 ; i--) {
				tempNode = tempNode.getPrev();
			}
			Node<NodeType> switchNode = tempNode.getPrev();
			
			switchNode.setNext(newNode);
			newNode.setPrev(switchNode);
			newNode.setNext(tempNode);
			tempNode.setPrev(newNode);
			
		}
		count++;
		
	}
	
	public void deleteFirst() {
		root = root.getNext();
		root.setPrev(null);
		
		count--;
	}
	
	public void deleteLast() {
		tail = tail.getPrev();
		tail.setNext(null);
		count--;
	}
	
	public void deleteAt(int position) {
		
		if(position <= 0) {
			deleteFirst();
			return;
		}
		else if(position >= count) {
			deleteLast();
			return;
		}
		else if(position < count/2){
			Node<NodeType> tempNode = root;
			for(int i = 0;i < position -1; i++) {
				tempNode = tempNode.getNext();
			}
			Node<NodeType> switchNode = tempNode.getNext().getNext();
			tempNode.setNext(switchNode);
			switchNode.setPrev(tempNode);
		}
		else if (position> count/2) {
			Node<NodeType>tempNode = tail;
			for(int i = count-1; i > position+1;i--) {
				tempNode = tempNode.getPrev();
			}
			Node<NodeType>switchNode = tempNode.getPrev().getPrev();
			
			tempNode.setPrev(switchNode);
			switchNode.setNext(tempNode);
		}
		count--;
	}
	
	public Node<NodeType> getPrev(int position){
		Node<NodeType> tempNode = root;
		for(int i = 0;i < position;i++) {
			tempNode = tempNode.getNext();
		}
		return tempNode.getPrev();
	}
}
