package STACK_구현;

import java.util.List;
import java.util.ArrayList;

public class Solution<T> {
	List<T> stack = new ArrayList<>();
	int idx = -1;
	
	public Solution() {}
	
	public void push(T Object) {
		stack.add(Object);
		idx += 1;
	}
	
	public boolean isEmpty() {
		return idx == -1;
	}
	
	public T pop() {
		if (isEmpty()) {
			System.out.println("실패");
			return null;
		}
		T Object = stack.get(idx);
		stack.remove(idx);
		idx -= 1;
		return Object;
	}
	
	public T peek() {
		if (isEmpty()) {
			System.out.println("실패");
			return null;
		}
		T Object = stack.get(idx);
		return Object;
	}
	
	public static void main(String[] args) {
		Solution<Integer> sl = new Solution();
		sl.push(10);
		System.out.println(sl.peek());
		System.out.println(sl.pop());
		System.out.println(sl.isEmpty());
	}
	
}