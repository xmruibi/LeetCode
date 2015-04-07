package array.medium.combPermutation;

public class NextPermutation {

	/**
	 * 1. From right to left, find the first digit (Partition Number) which
	 * violate the increase trend 2. From righ to left again, to find the first
	 * digit which large than Partition Number, call it Change number. 3. Swap
	 * these two number 4. Reverse all digits on the right of the Partition
	 * number original index
	 * 
	 * @param num
	 */
	public static void nextPermutation(int[] num) {
		if (num == null || num.length == 0)
			return;
		int partitionNumber = -1; // index
		int changeNumber = -1; // index
		// From right to left, find the first digit (Partition Number) which
		// violate the increase trend
		for (int i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				partitionNumber = i;
				break;
			}
		}

		// From righ to left again, to find the first digit which large than
		// Partition Number, call it Change number.
		if (partitionNumber >= 0) {
			for (int i = num.length - 1; i >= 0; i--) {
				if (num[i] > num[partitionNumber]) {
					changeNumber = i;
					break;
				}
			}
			// Swap these two number
			int swap = num[partitionNumber];
			num[partitionNumber] = num[changeNumber];
			num[changeNumber] = swap;
		}

		// Reverse all digits on the right of the Partition number original
		// index
		int left = partitionNumber + 1;
		int right = num.length - 1;
		while (left < right) {
			int tmp = num[left];
			num[left] = num[right];
			num[right] = tmp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		int[] num = { 3, 2, 1 };
		nextPermutation(num);
		for (int i : num)
			System.out.print(i + " ");
	}
}
