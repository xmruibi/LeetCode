package string.medium;

import java.util.Stack;

public class SimplifyPath {
	/**
	 * The rule of simplify path are according to the substring between '/': 1.
	 * str = "" OR ".": Do nothing 2. str = ".." AND stack is not empty: stack
	 * pop(); stack is empty: Do nothing 3. str = "somepath" stack push(str)
	 * 
	 * @param path
	 * @return
	 */
	public static String simplifyPath(String path) {

		Stack<String> stack = new Stack<String>();
		int preIdx = 0;
		int curIdx = 0;
		while (curIdx < path.length()) {
			while (curIdx < path.length() && path.charAt(curIdx) != '/')
				curIdx++;
			if (curIdx == preIdx) {
				preIdx = curIdx + 1;
			} else if(preIdx<curIdx){
				if (curIdx == path.length() - 1 && path.charAt(curIdx) != '/')
					curIdx++;
				String sub = path.substring(preIdx, curIdx);
				preIdx = curIdx + 1;
				if (sub.equals("..")) {
	                if (stack.empty()) {
	                    continue;
	                }
					stack.pop();
				} else if (!sub.equals(".")) {
					stack.push(sub);
				}
			}
			curIdx++;
		}
		StringBuilder sb = new StringBuilder();
		if(stack.isEmpty())
		    return "/";
		while (!stack.isEmpty())
			sb.insert(0, "/"+stack.pop());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(simplifyPath("/../"));
	}
}
