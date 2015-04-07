package string.easy.reverseProblem;

import java.util.Stack;

public class ReverseWord {
    public static String reverseWords(String s) {
        if(s==null||s.length()==0)
        	return "";
        int idx = 0;
        int pre = 0;
        Stack<String> words = new Stack<String>();
        while(idx<s.length()){
        	while(idx<s.length()&&s.charAt(idx)==' ')
        		idx++;
        	if(idx>=s.length())
        		break;
        	pre = idx;
        	while(idx<s.length()&&s.charAt(idx)!=' ')
        		idx++;
        	words.push(idx==s.length()?s.substring(pre):s.substring(pre, idx));
        	idx++;
        }
        String res ="";
        while(!words.isEmpty()){
        	res+=words.pop()+" ";
        }
        return res.trim();
    }
    
    public static void main(String[] args) {
		System.out.println(reverseWords( "   a   b "));
	}
}
