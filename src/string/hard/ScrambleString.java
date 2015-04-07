package string.hard;

import java.util.Arrays;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {

		int len = s1.length();
		if (len != s2.length())
			return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if (!Arrays.equals(c1, c2))
			return false;

		 boolean[][][] canScramble = new boolean[len][len][len+1];   // i,j with sublength  
	        for(int i=0; i<len; i++) {  
	            for(int j=0; j<len; j++) {  
	                canScramble[i][j][1] = s1.charAt(i) == s2.charAt(j);    // substring start from i with length 1, compared with substring start from j with length 1  
	            }  
	        }  
	          
	        for(int sublen=2; sublen<=len; sublen++) {  
	            // end_pos = x+(sublen-1) <= len-1, so x <= len-sublen  
	        	// check when sublength == k, m is a middle number of k 
				// then i->(i+m)==j->(j+m)?and (i+m)->(i+k)==(j+m)->(j+k)?
				// or i->(i+m)==(j+k-m)->(j+k)? and(i+m)->(i+k)==(j)->(j+(k-m)-1) 
	            for(int i=0; i<=len-sublen; i++) {  
	                for(int j=0; j<=len-sublen; j++) {  
	                    for(int p=1; p<sublen; p++) {       // split position  
	                        canScramble[i][j][sublen] |= (canScramble[i][j][p] && canScramble[i+p][j+p][sublen-p]) ||   
	                                                     (canScramble[i][j+sublen-p][p] && canScramble[i+p][j][sublen-p]);  
	                    }  
	                }  
	            }  
	        }  
	          
	        return canScramble[0][0][len];  
	}
}
