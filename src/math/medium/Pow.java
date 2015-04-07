package math.medium;

public class Pow {
	public static double pow(double x, int n) {
		if (n == 0)
			return 1.0;
		double res = 1.0;
		boolean neg = n < 0 ? true : false;
		while (n !=0) {
			if (n % 2 != 0)
				res *= x;
			x *= x;
			System.out.println(res);
			n /= 2;
		}

		return neg ? 1.0 / res : res;
	}

	public static void main(String[] args) {
		System.out.println(pow(2, 6));
	}
}
