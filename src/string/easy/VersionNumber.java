package string.easy;

public class VersionNumber {
	public static int compareVersion(String version1, String version2) {

		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i, res = 0;
		for (i = 0; i < v1.length && i < v2.length; i++) {
			res = Integer.valueOf(v1[i]).compareTo(Integer.valueOf(v2[i]));
			if (res != 0)
				return res;
		}
		while (i < v1.length ) {
			if (Integer.parseInt(v1[i]) > 0)
				return 1;
			i++;
		}
		while (i < v2.length ) {
			if (Integer.parseInt(v2[i]) > 0)
				return -1;
			i++;
		}
		return i==v1.length||i==v2.length?0:Integer.valueOf(version1).compareTo(Integer.valueOf(version2));
	}

	
	public static void main(String[] args) {
		System.out.println(compareVersion("1.1", "1"));
	}
}
