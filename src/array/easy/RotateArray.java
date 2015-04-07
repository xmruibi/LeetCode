package array.easy;

public class RotateArray {
	public static void rotate(int[] nums, int k) {
		while (k > 0) {
			int tmp = nums[nums.length - 1];
			for (int i = nums.length - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = tmp;
			k--;
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
		int[] nums2 = { 1, 2, 3 };

		rotate(nums1, 3);
		rotate(nums2, 4);
		for (int i : nums1)
			System.out.print(i+" ");
		
		System.out.println();
		for(int i:nums2)
			System.out.print(i+" ");
	}
}
