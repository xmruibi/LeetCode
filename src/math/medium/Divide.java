package math.medium;

public class Divide {
	/**
	 * Continuous Minus will TLE
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide(int dividend, int divisor) {
        if(divisor==0)
        	return -1;
        if(dividend==0)
        	return 0;
        int res=0;
        boolean neg = false;
        if(dividend<0)
        	neg = true^neg;
        if(divisor<0)
        	neg = true^neg;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        while(dividend>=divisor){
        	dividend-=divisor;
        	res++;
        }       
        return neg?0-res:res;
    }
	
	/**
	 * The best method should use the bit manipulation
	 * @param dividend
	 * @param divisor
	 * @return
	 */
//	public static int divide2(int dividend, int divisor) {
//		
//	}
	public static void main(String[] args) {
		System.out.println(divide(Integer.MAX_VALUE, -1));
	}
}
