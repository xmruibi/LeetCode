package array.medium.binarySearch;

public class FindPeakElement {
    public static int findPeakElement(int[] num) {
        int l =0, r = num.length-1;
        while(l<=r){
        	int m =l+((r-l)>>1);
        	if(l==r)
        		return l;
        	if(num[m]<num[m+1]){
        		l = m+1;
        	}else{
        		r = m;
        	}
        }
        return 0;
    }
    
    public static void main(String[] args) {
		int[] num = {1,3,2,4,5,2,3,1};
		System.out.println(findPeakElement(num));
	}
}
