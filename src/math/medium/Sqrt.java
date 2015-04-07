package math.medium;

public class Sqrt {
	public static int sqrt(int x) {

		if (x < 0)
			return -1;
		if(x==0)
			return 0;
		
		int l = 1;
		int r = x / 2;
		while (l <= r) {
			int m = l + ((r - l) >> 1);
			if (m + 1 > x / (m + 1) && m <= x / m) {
				return m;
			}
			if (m < x / m)
				l = m + 1;
			else
				r = m;
		}
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println(sqrt(3));
	}
}
