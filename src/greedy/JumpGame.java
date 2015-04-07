package greedy;

public class JumpGame {
    public boolean canJump(int[] A) {
        if(A.length==0)
        	return true;
    	
        int next =A[A.length-1];
    	for(int i =A.length-2;i>=0; i++){
    		if(A[i]>=next - i){
    			next = i;
    		}
    	}
    	
    	return next==0;
    }
}
