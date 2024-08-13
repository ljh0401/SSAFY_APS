package Linked_Stack_구현;

// Linked_Stack 구현 위한 Node 구현
public class Node<T> {
	T data;
	Node<T> next;
	
	Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	T getData() {
		return data;
	}
	
	void setData(T data) {
		this.data = data;
	}
	
	Node<T> getNext() {
		return next;
	}
	
	void setNext(Node<T> next) {
		this.next = next;
	}
}
