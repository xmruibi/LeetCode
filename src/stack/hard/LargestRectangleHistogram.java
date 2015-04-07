package stack.hard;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleHistogram {
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		height = Arrays.copyOf(height, height.length + 1);
		for (int i = 0; i < height.length; i++) {
			while(!stack.isEmpty()&&height[i]<=height[stack.peek()]){
				// compare current element and stack top element
				int prevIdx = stack.pop();
				int curArea = (stack.isEmpty()?i:(i-stack.peek()-1))*height[prevIdx];
				// the height should be referenced to previous first index
				// the width should be referenced to stack top element
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		return maxArea;
	}
}
