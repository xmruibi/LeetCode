package hashtable.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find. add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the
 * value.
 * 
 * @author xmrui_000
 *
 */
public class TwoSumIII {
	private final Map<Integer, Integer> dict;

	public TwoSumIII() {
		dict = new HashMap<Integer, Integer>();
	}

	/**
	 * Add element in to map 
	 * @param num
	 */
	public void add(int num) {
		if (dict.containsKey(num))
			dict.put(num, dict.get(num) + 1);
		else
			dict.put(num, 1);
	}

	/**
	 * Find two num in map can be sum as the input num
	 * 
	 * @return exist or not
	 */
	private boolean find(int num) {
		boolean found = false;
		for (Entry<Integer, Integer> e : dict.entrySet()) {
			if (dict.containsKey(num - e.getKey())) {
				found = true;
				break;
			}
		}
		return found;
	}

	public static void main(String[] args) {
		TwoSumIII util = new TwoSumIII();
		util.add(1);
		util.add(3);
		util.add(5);

		System.out.println(util.find(4));
		System.out.println(util.find(7));
	}
}
