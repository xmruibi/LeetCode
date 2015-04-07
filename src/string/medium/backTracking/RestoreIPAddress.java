package string.medium.backTracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if(s==null || s.length()==0||s.length()>12)  
	        return res;
		helper(res, 1, 0, "", s);
		return res;
	}

	private void helper(List<String> res, int segment, int idx, String cur,
			String s) {
		if (idx >= s.length())
			return;
		if (segment == 4) {
			String str = s.substring(idx);
			if (isValid(str)) {
				cur += ("." + str);
				res.add(cur);
				return;
			}
		}
		for(int i=1;i<4&& (i + idx <= s.length());i++){
			String str = s.substring(idx, idx+i);
			if(isValid(str)){
				if(segment == 1){
					helper(res, segment+1, idx+i, str, s);
				}else{
					cur+=("."+str);
					helper(res, segment+1, idx+i, cur, s);
				}
			}
		}
	}

	private boolean isValid(String str) {
		if (str == null || str.length() > 3)
			return false;
		if (str.length() > 1 && str.charAt(0) == '0')
			return false;
		if (Integer.parseInt(str) <= 255 && Integer.parseInt(str) >= 0)
			return true;
		return false;

	}
}
