package array.medium.removeDups;

public class RemoveDupsFromSortedArray {
	public static int removeDuplicates(int[] A) {
		if (A.length <=1)
			return A.length;
		int curVal = A[0];
		int len = 0;
		for (int i = 1; i < A.length; i++) {
			// check from index 1; 
			if (curVal != A[i]) {
				// if check current value is not equal to next value;
				// move curVal to nextVal  
				curVal = A[i];
				 A[++len]=curVal;
			}
		}
		for (int i : A)
			System.out.print(i + " ");
		return len + 1;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1 };
		int[] B = { 1, 2, 3, 3, 3, 3, 3 };
		System.out.println(removeDuplicates(A));
		System.out.println(removeDuplicates(B));
	}
}
