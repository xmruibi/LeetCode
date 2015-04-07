package math.medium.excelProblem;

public class ExcelNumber {
	public int titleToNumber(String s) {
		if(s==null||s.length()==0)
			return 0;
		int res=0;
		for(int i=0;i<s.length();i++){
			int cur = s.charAt(i)-'A'+1;
			res = res*26+cur;
		}
		return res;
	}
	
    public String convertToTitle(int n) {
    	if(n<=0)
    		return null;
    	StringBuilder sb = new StringBuilder();
    	while(n>0){
    		if(n%26==0){
    			sb.insert(0, 'Z');
    			n--;
    		}else
    			sb.insert(0, (char) ('A'+(n%26)-1));
    		n/=26;
    	}
    	return sb.toString();
    }
}
