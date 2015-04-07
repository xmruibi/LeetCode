package string.easy;

public class LengthLastWord {

    public int lengthOfLastWord(String s) {
    	if(s==null||s.length()==0)
    		return 0;
    	int last = s.length()-1;
        while(last>=0&&!isAlphabet(s.charAt(last)))
        	last--;
        int len = 0;
        while(last-len>=0&&isAlphabet(s.charAt(last-len)))
        	len++;
        return len;
    }
	private boolean isAlphabet(char c) {
		if ((c>=48&&c<=57)||(c - 'A' <= 26 && c - 'A' >= 0) || (c - 'a' <= 26 && c - 'a' >= 0))
			return true;
		else
			return false;
	}
}
