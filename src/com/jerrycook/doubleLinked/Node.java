package com.jerrycook.doubleLinked;

public class Node<NodeType> {

	public NodeType value;
	public Node<NodeType> prevNode;
	public Node<NodeType> nextNode;
	
	
	public Node(NodeType value) {
		this.value = value;
	}
	
	public void setValue(NodeType value) {
		this.value = value;
	}
	
	public NodeType getValue() {
		return value;
	}
	
	public void setNext(Node<NodeType> next) {
		this.nextNode = next;
	}
	
	public Node<NodeType> getNext(){
		return nextNode;
	}
	
	public void setPrev(Node<NodeType> prev) {
		this.prevNode = prev;
	}
	
	public Node<NodeType> getPrev(){
		return prevNode;
	}
}
