package array.easy;

import java.util.Arrays;

public class RemoveElement {
	/**
	 * Move Elements by manipulate index
	 * @param A
	 * @param elem
	 * @return new length after removed target element
	 */
	public static int removeElement(int[] A, int elem) {
		int len = 0;
		for (int cur = 0; cur < A.length; cur++) {
			if (A[cur] != elem) { 
				// it seems more convenient to change length
				// when current item is not equal to target element
				A[len] = A[cur];
				len++;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4, 4, 6, 4 };

		System.out.println(removeElement(num, 4));
	}
}
