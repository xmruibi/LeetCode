package string.easy;

import java.util.Stack;

public class ValidParenthese {
	public boolean isValid(String s) {
		if (s.length() == 0)
			return true;
		if (s.length() % 2 != 0)
			return false;
		Stack<Character> stack = new Stack<Character>();
		int idx = 0;
		while (s.length() > idx) {
			if (s.charAt(idx) == '{' || s.charAt(idx) == '('
					|| s.charAt(idx) == '[')
				stack.push(s.charAt(idx));
			else if (!stack.isEmpty())
				if (s.charAt(idx) == '}') {
					if (stack.pop() != '{')
						return false;
				} else if (s.charAt(idx) == ']') {
					if (stack.pop() != '[')
						return false;
				} else if (s.charAt(idx) == ')') {
					if (stack.pop() != '(')
						return false;
				}
			idx++;
		}
		return stack.isEmpty();
	}
}
