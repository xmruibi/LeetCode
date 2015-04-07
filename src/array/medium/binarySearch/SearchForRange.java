package array.medium.binarySearch;

public class SearchForRange {
	public static int[] searchRange(int[] A, int target) {

		int start = range(A, target);

		if (start == A.length || A[start] != target) {
			return new int[] { -1, -1 };
		}
		return new int[] { start, range(A, target + 1) - 1 };
	}

	private static int range(int[] A, int target) {
		// TODO Auto-generated method stub

		int low = 0, high = A.length;
		while (low < high) {
			int mid = low + ((high - low) >> 1);
			// low <= mid < high
			if (A[mid] < target) {
				low = mid + 1;
			} else {
				// should not be mid-1 when A[mid]==target.
				// could be mid even if A[mid]>target because mid<high.
				high = mid;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		int[] num = { 5, 7, 7, 8, 8, 9 };
		System.out.println(searchRange(num, 8)[0]);
	}
}
