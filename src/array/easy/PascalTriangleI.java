package array.easy;

import java.util.List;
import java.util.ArrayList;

public class PascalTriangleI {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return res;
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		res.add(row);
		if (numRows == 1)
			return res;
		for (int i = 2; i <= numRows; i++) {
			List<Integer> last = new ArrayList<Integer>(row);
			row = new ArrayList<Integer>();
			row.add(1);
			for (int j = 1; j < i - 1; j++) {
				row.add(last.get(j) + last.get(j - 1));
			}
			row.add(1);
			res.add(row);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(generate(5));
	}
}
