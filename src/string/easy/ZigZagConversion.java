package string.easy;

public class ZigZagConversion {
    public static String convert(String s, int nRows) {
    	if(nRows<=1)
			return s;
    	StringBuilder sb = new StringBuilder();
    	int len = s.length();
    	int gap = 2*nRows-2;
    	for(int i=0;i<nRows;i++){
    		for(int j=i;j<len;j+=(gap)){
    			sb.append(s.charAt(j));
    			if(i>0&&i<nRows-1&&(j+gap-i*2)<len){
    				sb.append(s.charAt(j+gap-i*2));
    			}
    		}
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
}
