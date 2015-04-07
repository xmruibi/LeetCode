package dp.hard;

public class EditDistance {
	public static int minDistance(String word1, String word2) {

		if (word1.length() == 0 || word1 == null)
			return word2 == null ? 0 : word2.length();
		if (word2.length() == 0 || word2 == null)
			return word1.length();

		int[][] memo = new int[word1.length()+1][word2.length()+1];
		// initial
		memo[0][0] =0;
    	for (int i = 0; i <= word1.length(); i++){memo[i][0] = i;}
   		for (int j = 0; j <= word2.length(); j++){memo[0][j] = j;}

		for (int i = 1; i <= word1.length(); i++)
			for (int j = 1; j <= word2.length(); j++) {
				int curMin = Math.min(memo[i][j - 1],
						Math.min(memo[i - 1][j - 1], memo[i - 1][j]));
				memo[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? memo[i - 1][j - 1]
						: curMin + 1;
			}
		return memo[word1.length()][word2.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(minDistance("zoologicoarchaeologist", "zoogeologist"));
	}
}
