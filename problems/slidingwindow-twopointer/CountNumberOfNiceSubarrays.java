import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.
Converting this problem with 1 as odd number and 0 as even number.
 */
// This Problem is similar to the BinarySubArrayWithSum problem.
public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        int sum = 0 ; 
        int count = 0 ; 
        for(int i =0;i<nums.length;i++){
            sum = sum+nums[i]%2; // converting the problem to BinarySubArrayWithSum problem. odd as 1 and even as 0.
            count+=prefix.getOrDefault(sum-k,0);
           prefix.put(sum,prefix.getOrDefault(sum,0)+1);
        }
        return count; 
    }

    // Using the same logic as the BinarySubArrayWithSum problem.
    public int numberOfSubarrays2(int[] nums, int k) {
        return countNumber(nums, k) - countNumber(nums, k - 1);
    }

    int countNumber(int[] nums, int k) {
        if(k < 0 ) return 0; 
        int l = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] % 2;
            while (sum > k) {
                sum = sum - (nums[l] % 2);
                l++;
            }
            count = count + (i - l + 1);
        }
        return count;
    }
}
