package array.hard;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	
	 public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		 List<Interval> res = new ArrayList<Interval>();
			res.add(newInterval);
		 if(intervals==null)
			 return res;
		 for(Interval interval:intervals){
			 int start = res.get(res.size()-1).start;
			 int end = res.get(res.size()-1).end;
			 if(start>interval.end)
				 res.add(res.size()-1, interval);
			 else if(end<interval.start)
				 res.add(interval);
			 else{
				 start = Math.min(start, interval.start);
				 end = Math.max(end, interval.end);
				 res.set(res.size()-1, new Interval(start, end));
			 }
		 }
		 return res;
	 }
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}