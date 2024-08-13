package Linked_Stack_구현;

public class Linked_Stack<T> {
	Node<T> top;
	int size;
	
	Linked_Stack() {
		this.top = null;
		size = 0;
	}
	
	// push 구현
	void push(T data) {
		Node<T> newNode = new Node<>(data, top);
		top = newNode;
		size++;
	}
	
	// pop 구현
	T pop() {
		if(isEmpty()) {
			System.out.println("������ ��� �ֽ��ϴ�.");
			return null;
		}
		T data = top.getData();
		top = top.getNext();
		size--;
		return data;
	}
	
	// peek 구현
	T peek() {
		if(isEmpty()) {
			System.out.println("������ ��� �ֽ��ϴ�.");
			return null;
		}
		T data = top.getData();
		return data;
	}
	
	// isEmpty 구현
	boolean isEmpty() {
		return size == 0;
	}
	
	// size 구현
	int size() {
		return size;
	}
	
}
