package dp.hard;

public class WildMatch {
	public boolean isMatch(String s, String p) {

		int slen = s.length();
		int plen = p.length();
		boolean[][] memo = new boolean[slen + 1][plen + 1];

		for (int i = 0; i <= slen; i++) {
			for (int j = 0; j <= plen; j++) {
				if(j==0)
					memo[i][j] = i==0;
				else if(i==0)
					memo[i][j] = p.charAt(j-1)=='*'&&memo[i][j-1];
				else if(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='?')
					memo[i][j] = memo[i-1][j-1];
				else if(p.charAt(j-1)=='*')
					memo[i][j] = memo[i-1][j]||memo[i-1][j-1]||memo[i][j-1];
			}
		}
		return memo[slen][plen];
	}
}
