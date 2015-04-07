package string.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		List<String> res = new ArrayList<String>();
		if (strs == null || strs.length == 0)
			return res;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		// here using the list as the value!

		for (int i = 0; i < strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String newstr = new String(chars);
			if (map.containsKey(newstr)) {
				map.get(newstr).add(strs[i]);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(newstr, list);
			}
		}

		Iterator iter = map.values().iterator();
		while (iter.hasNext()) {
			ArrayList<String> item = (ArrayList<String>) iter.next();
			if (item.size() > 1)
				res.addAll(item);
		}

		return res;

	}
}
