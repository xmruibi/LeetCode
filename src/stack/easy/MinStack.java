package stack.easy;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> min;

	public MinStack() {
		stack = new Stack<Integer>();
		min = new Stack<Integer>();
	}

	public void push(int x) {
		stack.push(x);
		if (min.isEmpty() || min.peek() >= x)
			min.push(x);

	}

	public int pop() { // be careful the equal method!!!
		if(stack.peek().equals(min.peek()))
			min.pop();
		return stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min.isEmpty()?0:min.peek();
	}
}
