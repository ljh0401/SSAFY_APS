package QUEUE_구현;

public class Solution<T> {
    int front = -1;
    int rear = -1;
    T[] queue;

    // T를 써서 구현해보고 싶어서 찾아봤습니다.
    @SuppressWarnings("unchecked")
    public void make(int size) {
    	this.queue = (T[]) new Object[size];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == queue.length-1;
    }

    public void enQueue(T object) {
        if(isFull()) {
            System.out.println("enQueue error");
            return;
        }
        queue[++rear] = object;
    }

    public T deQueue() {
        if(isEmpty()) {
            System.out.println("deQueue error");
            return null;
        }
        return queue[++front];
    }

    public T Qpeek() {
        if(isEmpty()) {
            System.out.println("Qpeek error");
            return null;
        }
        return queue[front+1];
    }
    public int size() {
        return rear - front;
    }

    // 그냥 만들어본 초기화 함수
    public void reset() {
        rear = -1;
        front = -1;
        for (int i = 0; i <10  ;i++) {
            queue[i] = null;
        }
    }
    
    public static void main(String[] args) {
    	Solution<Integer> sl = new Solution<>();
    	sl.make(10);
    	sl.enQueue(100);
    	System.out.println(sl.deQueue());
    	System.out.println(sl.isEmpty());
    }
}