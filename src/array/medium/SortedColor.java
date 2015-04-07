package array.medium;

public class SortedColor {
	public void sortColors(int[] A) {
        if(A==null || A.length==0)  
            return;
        // record current zero and one position with increasing
		int zero = 0;
		int one = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				A[i]=2;
				A[zero++]=0;
				A[one++]=1;
			}else if(A[i]==1){
				A[i] = 2;
				A[one++]=1;
			}
		}
	}
}
