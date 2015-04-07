package array.medium.dp;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        
    	if(triangle==null||triangle.size()==0)
    		return 0;
    	
    	for(int row = triangle.size()-2;row>=0;row--){
    		for(int col = triangle.get(row).size()-1;col>=0;col--){
    			int cur = triangle.get(row).get(col)+Math.min(triangle.get(row+1).get(col),triangle.get(row+1).get(col+1));
    			triangle.get(row).set(col,cur);
    		}
    	}
    	return triangle.get(0).get(0);
    }
    
    
}
