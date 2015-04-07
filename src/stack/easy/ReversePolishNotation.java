package stack.easy;

import java.util.Stack;

public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if (tokens == null)
			return 0;
		int res = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (String str : tokens) {
				if (str.equals("+")){
					res = stack.pop() + stack.pop();
					stack.push(res);
				}else if (str.equals("-")){
					res = stack.pop();
					res = stack.pop() - res;
					stack.push(res);
				}else if (str.equals("/")){
					res = stack.pop();
					if (res == 0)
						return Integer.MIN_VALUE;
					res = stack.pop() / res;
				}else if(str.equals("*")){
					res = res * stack.pop();
					stack.push(res);
				}else 
					stack.push(Integer.parseInt(str));

		}
		if (!stack.isEmpty())
			res = stack.pop();
		return stack.isEmpty() ? res : Integer.MIN_VALUE;
	}
}
