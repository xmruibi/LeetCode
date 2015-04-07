package string.medium;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacter {
	/**
	 * Two iteration method: boolean array ;
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		boolean[] table = new boolean[256];
		int len = 0, idx = 0, maxLen=0;
		while (idx < s.length()){
			while (table[s.charAt(idx)]) {
				table[s.charAt(len)] = false;
				len++;
			}
			table[s.charAt(idx)]=true;  // recover the previous step's modification
			maxLen = Math.max(maxLen, idx-len+1);
			idx++;
		}
		return maxLen;
	}
	
	
	private int lengthOfLongestSubstring2(String s) {
		int[] charMap = new int[256]; // 
		Arrays.fill(charMap, -1);
		int i = 0, maxLen = 0;
		for(int j=0;j<s.length();j++){
			if(charMap[s.charAt(j)]>=i){
				i = charMap[s.charAt(j)] + 1;
			}
			charMap[s.charAt(j)] = j;
			maxLen = Math.max(j-i+1, maxLen);
		}
		return maxLen;
	}
}
