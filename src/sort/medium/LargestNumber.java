package sort.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public static String largestNumber(int[] num) {
        Comparator<Integer> compare = new Comparator<Integer>() {	
			@Override
			public int compare(Integer o1, Integer o2) {
				String ab = String.valueOf(o1)+String.valueOf(o2);
				String ba = String.valueOf(o2)+String.valueOf(o1);
				o1 = Integer.parseInt(ab);
				o2 = Integer.parseInt(ba);
				return o2.compareTo(o1);
			}
		};
		List<Integer> list = new ArrayList<Integer>();

		for(int i:num)
			list.add(i);
		
		list.sort(compare);
		StringBuilder sb =  new StringBuilder();
		for(int i:list){
			sb.append(i);
		}
		return sb.toString();
    }
    
    public static void main(String[] args) {
    		int[] num = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(num));
	}
}
