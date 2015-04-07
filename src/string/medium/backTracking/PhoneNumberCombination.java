package string.medium.backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberCombination {
	static Map<Character, String> map = new HashMap<Character, String>();

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		map.put('0', " ");

		backTrack(res, new String(), digits, 0);
		return res;
	}

	private static void backTrack(List<String> res, String cur, String digits,
			int idx) {
		if (idx == digits.length()) {
			res.add(new String(cur));
			return;
		}

		String str = map.get(digits.charAt(idx));
		for (int j = 0; j < str.length(); j++) {
			cur += str.charAt(j);
			backTrack(res, cur, digits, idx + 1);
			cur = cur.substring(0, cur.length() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
}
