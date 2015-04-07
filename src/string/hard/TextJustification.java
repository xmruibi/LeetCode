package string.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public static List<String> fullJustify(String[] words, int L) {
		List<String> res = new ArrayList<String>();
		if (words == null || words.length == 0)
			return res;

		int curLine = 0;
		int prev = 0;
		int space = 0;
		for (int i = 0; i < words.length; i++) {
			curLine += words[i].length();
			if (curLine + (i - prev) >= L) {
				curLine -= words[i].length();
 				if (i - prev > 0)
					space = (L - curLine) / ((i--) - prev);
				StringBuilder sb = new StringBuilder();
				while (prev <= i) {
					sb.append(words[prev++]);
					for (int s = 0; s < space; s++)
						sb.append(" ");
				}
				sb.append(words[prev++]);
				res.add(sb.toString());
				curLine = 0;
				space = 0;
			} else if (i == (words.length-1)) {
				StringBuilder sb = new StringBuilder();
				space = (L - curLine) / (i - prev + 1);
				while (prev <= i) {
					sb.append(words[prev++]);
					for (int s = 0; s < space; s++)
						sb.append(" ");
				}
				res.add(sb.toString());
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] arr = {"Listen","to","many,","speak","to","a","few."};
		System.out.println(fullJustify(arr, 6));
	}

}
