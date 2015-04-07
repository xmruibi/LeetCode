package array.medium;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
	public List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> ranges = new ArrayList<String>();
		int low = start - 1; // only need to maintain this value, once the value
								// in array is larger than low with 2 units

		for (int i = 0; i < vals.length; i++) {
			int cur = (i == vals.length - 1) ? end + 1 : vals[i];
			// end + 1 if in last index
			if (cur > low + 1)
				ranges.add(new String((low + 1) == (cur - 1) ? String
						.valueOf(low + 1) : (low + 1 + "->" + (cur - 1))));
			low = cur;
		}
		return ranges;
	}
}
