package hashtable.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class DNAsequence {
	/**
	 * find all the 10-letter-long sequences (substrings) that occur more than
	 * once in a DNA molecule.
	 * 
	 * @param s
	 * @return
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < s.length(); i += 10) {
			String str = s.substring(i, i + 10);
			int hashCode = hashFuntion(str);
			if (set.contains(hashCode)) {
				if (!res.contains(str))
					res.add(str);
			} else
				set.add(hashCode);
		} 
		return res;
	}

	private int hashFuntion(String s) {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			char c = s.charAt(i);
			int cur = 0;
			if (c == 'A')
				cur = 0;
			if (c == 'C')
				cur = 1;
			if (c == 'G')
				cur = 2;
			if (c == 'T')
				cur = 3;
			sum = sum << 2;
			sum |= cur;
		}
		return sum;
	}
}
