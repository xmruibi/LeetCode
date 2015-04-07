package array.medium.binarySearch;

public class SearchInsertPosition {
	 public int searchInsert(int[] A, int target) {
	       if (A == null || A.length == 0)
				return 0;
			int l = 0;
			int r = A.length - 1;
			
			while(l<=r){
				int m = l+((r-l)>>1);
				if(A[m]==target)
					return m;
				if(A[m]<target)
					l = m+1;
				else
					r = m-1;
			}
			return l;
	 }
}
