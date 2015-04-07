package array.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		if (rowIndex <= 0)
			return res;
		if (rowIndex == 1) {
			res.add(1);
			return res;
		}
		// recursion here 
		List<Integer> prev = getRow(rowIndex - 1);
		for (int i = 0; i < prev.size() - 1; i++) {
			res.add(prev.get(i) + prev.get(i + 1));
		}
		res.add(1);
		return res;
	}

	
	
	public static void main(String[] args) {
		System.out.println(getRow(0));
	}
}
