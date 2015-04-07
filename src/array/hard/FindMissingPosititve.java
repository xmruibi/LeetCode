package array.hard;

public class FindMissingPosititve {
	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0)
			return 1;

		//  put A[i] onto A[A[i]-1] , that  A[0] = 1, A[1] = 2.....
		// be careful to i--, so that start from original index to check new value
		for (int i = 0; i < A.length; i++) {
			if (A[i]>0&&A[i]<A.length&&A[i] != i+1) {
				int tmp = A[i];
				A[i] = A[tmp - 1];
				A[tmp - 1] = tmp;
				i--;
			}
		}
		
		//  iterate from idx 1 whichi is 1... 
		for(int i =0;i<A.length;i++){
			if(i+1!=A[i]) // here the "i" is index so the return should plus one
				return i+1;
		}
		
		
		return A.length+1;
	}
}
