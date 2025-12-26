import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> countmap = new HashMap<>();
        int remaing =0 ; 
        for(int i=0;i<nums.length;i++){
            remaing = target - nums[i];
            if(countmap.containsKey(remaing))
                return new int[]{i,countmap.get(remaing)};
            else 
                countmap.put(nums[i],i);
        }
        
        
        return new int[]{};
    }
}
