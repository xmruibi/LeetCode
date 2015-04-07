package array.medium.removeDups;

public class RemoveDupsFromSortedArrayII {
	public int removeDuplicates(int[] A) {
        if(A.length<=2)
        	return A.length;
		int len =2; // as the slow pointer
		for(int i=2;i<A.length;i++){
			if(A[i]!=A[len-2]){ // check index of len-2 
				A[len++] = A[i];
			}
		}
		return len;
	}
}
