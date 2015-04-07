package greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0||cost.length==0)
        	return -1;
        
        int remain =0;
        int start = 0;
        int len = gas.length;
        for(int i=0;i<2*len;i++){
        	remain += gas[i%len] - cost[i%len];
        	if(remain<0){
        		remain = 0; // start from here
        		start = i+1;
        	}
        }
        if(start>=len)
        	return -1;
        return start;
    }
}
