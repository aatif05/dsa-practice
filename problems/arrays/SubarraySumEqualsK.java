import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    
    public int subarraySum(int[] nums, int k) {
        int sum  = 0 ; 
        int tcount = 0 ; 
        Map<Integer,Integer> count = new HashMap<>();
        count.put(0,1);
        for(int i =0; i< nums.length;i++){
            sum = sum + nums[i];
           int remaining =  sum -k ;
          tcount= tcount+ count.getOrDefault(remaining,0);
          count.put(sum,count.getOrDefault(sum,0)+ 1);
        }

        return tcount;
    }
}
