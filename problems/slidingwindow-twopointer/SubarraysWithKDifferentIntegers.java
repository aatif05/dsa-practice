import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 */

public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubarray(nums, k) - countSubarray(nums, k - 1);

    }
    int countSubarray(int[] nums, int k) {
        if (k < 0)
            return 0;
        int count = 0;
        int l = 0;
        Map<Integer, Integer> val = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            val.put(nums[i], val.getOrDefault(nums[i], 0) + 1);
            while (val.size() > k) {
                val.put(nums[l], val.getOrDefault(nums[l], 0) - 1);
                if (val.get(nums[l]) == 0) {
                    val.remove(nums[l]);
                }
                l++;
            }
            if (val.size() <= k) {
                count = count + i - l + 1;
            }
        }
        return count;
    }
}
