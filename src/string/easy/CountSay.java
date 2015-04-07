package string.easy;

public class CountSay {
    public static String countAndSay(int n) {
    	if(n<=0)
    		return "";
    	if(n==1)
    		return "1";
        String res ="11";
    	for(int i=2;i<n;i++){
    		int idx = 1;
    		int count =1;
    		StringBuilder sb =new StringBuilder();
    		while(idx<res.length()){
    			if(res.charAt(idx-1)==res.charAt(idx)){
    				count++;
    			}else{
    				sb.append(count);
    				sb.append(res.charAt(idx-1));
    				count=1;
    			}
    			idx++;
    		}
    		if(idx==res.length()){
				sb.append(count);
				sb.append(res.charAt(idx-1));
    		}
    		res = sb.toString();
    	}
    	return res;    	
    }
    
    public static void main(String[] args) {
		System.out.println(countAndSay(3));
	}
}
