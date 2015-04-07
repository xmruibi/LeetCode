package string.easy;

public class String2Integer {
	public int atoi(String str) {
		if(str==null||str.length()==0)
			throw new IllegalArgumentException("Illegal Argument.");
		int idx =0;
		int sign=1;
		while(!isNumeric(str.charAt(idx))){
			if(str.charAt(idx)=='-')
				sign=-1;
			else if(sign==-1&&str.charAt(idx)=='+')
				sign=1;
			idx++;
		}
		int res=0;
		while( idx<str.length()&&isNumeric(str.charAt(idx))){
			res+=res*10+(str.charAt(idx)-'0');
			idx++;
		}
		return sign>0?res:-res;
	}

	private boolean isNumeric(char c) {
		return c - '0' < 10 && c - '0' >= 0;
	}
}
