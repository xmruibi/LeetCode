package string.medium.dp;

public class DecodeWay {
	public static int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int[] memo = new int[s.length()+1];
		memo[s.length()] = 1;
		memo[s.length()-1] = s.charAt(s.length()-1)=='0'?0:1;
		for (int i =s.length()-2;i>=0; i--) {
			if(s.charAt(i)=='0')
				continue;
			else if (isValid(s.substring(i - 1, i + 1)))
				memo[i] = memo[i + 1] + memo[i+2];
			else
				memo[i] = memo[i + 1];
		}
		return memo[0];
	}

	private static boolean isValid(String s) {
		if (Integer.parseInt(s) <= 26)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("126"));
	}
}
