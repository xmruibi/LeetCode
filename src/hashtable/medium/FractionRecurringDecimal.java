package hashtable.medium;

import java.util.HashMap;
import java.util.Map;

public class FractionRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "Illegal_Input";

		StringBuilder sb = new StringBuilder();

		// step one: deal with sign
		if ((numerator < 0 && denominator > 0)
				|| (numerator > 0 && denominator < 0)) {
			sb.append("-");
		}
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);
		
		// step two: get the number before decimal
		sb.append(numerator / denominator);
		
		// step three: addressing the digits behind decimal
		if (numerator % denominator != 0) {
			sb.append(".");
			final Map<Long, Integer> map = new HashMap<>();
			long remain;
			for (remain = numerator % denominator; remain != 0;) {
				if (map.containsKey(remain)) {
					sb.insert(map.get(remain), "(");
					sb.append(")");
					break;
				} else {
					map.put(remain, sb.length()); // mark the position for insert "("
				}
				remain *= 10;
				sb.append(remain / denominator);
				remain %= denominator;
			}
		}
		return sb.toString();
	}
}
