package dp.hard;

public class PalindromeSubstringII {
	public int minCut(String s) {

			int[] memo = new int[s.length()+1];
	
			// initial with the max value
			for(int i=0;i<=s.length();i++){
				memo[i] = s.length()-i;
			}
			
			boolean[][] palindromeRecord = new boolean[s.length()+1][s.length()+1];
			
			// dp
			for (int i = s.length() - 1; i >= 0; i--) {
				for (int j = i; j < s.length(); j++) {
					if(s.charAt(i)==s.charAt(j)&&(j-i<2||palindromeRecord[i+1][j-1])){ // string{i-n} = min(string{i,j}, string{j+1,n}) 
						palindromeRecord[i][j] = true;
						memo[i] = Math.min(memo[i], memo[j+1]+1);
					}
				}
			}
			
			return memo[0]-1;
	}

	// but this may cause TLE so we need to try dp way to record string{i,j} is palindrome
	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
