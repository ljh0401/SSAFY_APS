package Linked_Queue_구현;

public class Linked_Queue<T> {
	Node<T> front;
	Node<T> rear;
	int size;
	
	Linked_Queue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
	//isEmpty 구현
	boolean isEmpty() {
		return front == null;
	}
	
	// enQueue 구현
	void enQueue(T data) {
		Node<T> newNode = new Node<>(data, null);
		if (isEmpty()) {
			front = newNode;
		}
		else {
			rear.setNext(newNode);
		}
		rear = newNode;
		size++;
	}
	
	//deQueue 구현
	T deQueue() {
		if (isEmpty()) {
			System.out.println("Queue�� ��� �ֽ��ϴ�.");
			return null;
		}
		T data = front.getData();
		front = front.getNext();
		if (front == null) {
			rear = null;
		}
		size --;
		return data;
	}
	
	//peek 구현
	T peek() {
		if (isEmpty()) {
			System.out.println("Queue�� ��� �ֽ��ϴ�.");
			return null;
		}
		T data = front.getData();
		return data;
	}
	
	
	// size ����
	int size() {
		return size();
	}
}
