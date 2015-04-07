package greedy;

public class Candy {
	public int candy(int[] ratings) {
		int res = 0;
		int desc = 0;
		int prevCnt = 1;
		int curMaxCnt = prevCnt;

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] < ratings[i - 1]) {
				desc++; // descend
				if (desc == curMaxCnt)
					desc++; // when desc lead to over current max count
				res += desc;
				prevCnt = 1;
			} else {
				if (ratings[i] > ratings[i - 1])
					prevCnt++; // if asc
				else
					prevCnt = 1; // if equal
				res += prevCnt;
				desc = 0;// clear desc count
				curMaxCnt = prevCnt;// update current max
			}

		}

		return res;
	}
}
