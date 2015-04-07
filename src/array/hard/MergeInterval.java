package array.hard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
    	// notice this intervals list is not sorted!!
    	 List<Interval> res = new ArrayList<Interval>();
    	 if(intervals==null||intervals.size()==0)
    		 return res;
    	 Collections.sort(intervals, new Comparator<Interval>() {
    		 @Override
    		public int compare(Interval o1, Interval o2) {
    			return Integer.compare(o1.start, o2.start);
    		}
		});
    	 res.add(intervals.get(0));
    	 for(int i=1;i<intervals.size();i++){
    		 int start = res.get(res.size()-1).start;
    		 int end = res.get(res.size()-1).end;
    		 
    		 if(intervals.get(i).start>end){
    			 res.add(intervals.get(i));
    		 }else if(intervals.get(i).end<start){
    			 res.add(res.size()-1,intervals.get(i));
    		 }else{
    			 start = Math.min(start, intervals.get(i).start);
    			 end = Math.max(end, intervals.get(i).end);
    			 res.set(res.size()-1, new Interval(start,end));
    		 }
    	 }
    	 return res;
    }
}
