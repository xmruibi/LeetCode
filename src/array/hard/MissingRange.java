package array.hard;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
	public static List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> res = new ArrayList<String>();
		int prev = start - 1;

		for (int i = 0; i <= vals.length; i++) {
			int curDist;
			if (i != vals.length)
				curDist = vals[i] - prev;
			else
				curDist = end - prev;
			
			if (curDist > 2)
				res.add((prev + 1) + "—>" + String.valueOf(i != vals.length?(vals[i] - 1):(end)));
			else if (curDist > 1)
				res.add(String.valueOf(prev + 1));
			prev +=curDist;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] vals = { 0, 1, 3, 50, 75,96,99 };
		System.out.println(findMissingRanges(vals, 0, 99));
	}
}
