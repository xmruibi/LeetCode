package dp.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public static List<String> wordBreak(String s, Set<String> dict) {
		List<String> res = new ArrayList<String>();
		if (dict == null || dict.isEmpty() || s == null || s.length() == 0)
			return res;

		// array with list, each index saving a list of words in this position
		// notice how to instance a new array of lists;
		List<String> words[] = new ArrayList[s.length() + 1];
		words[0] = new ArrayList<String>(); // don't forget to instance position zero
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String str = s.substring(j, i);
				if (dict.contains(str) && words[j] != null) {
					if (words[i] == null) // here must instance a new
												// ArrayList for array unit
						words[i] = new ArrayList<String>();
					words[i].add(str);
				}
			}
		}
		if(words[s.length()]==null)
			return res;
		dfs(res, words, s.length(), new ArrayList<String>());
		return res;
	}

	// the dfs to iterate all possible result by scan the array of list;
	// notice that the scan order is from the rear of array of list;
	private static void dfs(List<String> res, List<String> words[], int idx, List<String> cur) {
		if(idx<=0){
			String newStr = "";
			for (int i=cur.size()-1;i>0;i--)
				newStr += cur.get(i) + " ";
			newStr+=cur.get(0);
			res.add(newStr);
			return;
		}
		
		for(String str:words[idx]){
			cur.add(str);
			dfs(res, words, idx-str.length(), cur);
			cur.remove(cur.size()-1);
		}
	}
}
