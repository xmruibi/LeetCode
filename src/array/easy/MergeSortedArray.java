package array.easy;

public class MergeSortedArray {
	/**
	 * A has enough space to save elements from both A and B
	 * 
	 * @param A
	 * @param m
	 *            is the number amount on A
	 * @param B
	 * @param n
	 *            is the number amount on B
	 */
	public void merge(int A[], int m, int B[], int n) {
		int len = m + n - 1;
		m--;
		n--;

		while (m > 0 && n > 0) {
			if (A[m] < B[n]) {
				A[len--] = B[n--];
			} else
				A[len--] = A[m--];
		}
		while (n > 0) {
			A[len--] = B[n--];
		}
	}
}
