package dp.hard;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (dict == null || dict.isEmpty() || s == null || s.length() == 0)
			return false;
		boolean[] memo = new boolean[s.length() + 1];
		memo[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String str = s.substring(j, i);
				if (dict.contains(str) && memo[j])
					memo[i] = true;
			}
		}
		return memo[s.length()];
	}
}
