public class BinarySubArrayWithSum {
    //Since we can have 0 or 1 in the array, we can use a sliding window to find the number of subarrays with the sum equal to the goal.
    //We are finding sub arrays with sum less than or equal to the goal.
    //Also finding sub arrays with sum less than or equal to goal - 1.
    //The difference between the two will give us the number of subarrays with sum equal to the goal.
    //Eg: Suppose we need to fine every one with wight 70Kg.
    //We can find all the subarrays with sum less than or equal to 70Kg.
    //Then we can find all the subarrays with sum less than or equal to 69Kg.
    //The difference between the two will give us the number of subarrays with sum equal to 70Kg.
    public int numSubarraysWithSum(int[] nums, int goal) {

        return fetchCount(nums, goal) - fetchCount(nums, goal - 1);

    }

    int fetchCount(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int left = 0;
        int sum = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum > goal) {
                sum = sum - nums[left];
                left++;
            }
            count = count + (right - left + 1);
        }
        return count;
    }
}
/*
This prefix sum works with every number in the array.
Map<Integer, Integer> prefix = new HashMap<>();
prefix.put(0, 1);
int sum = 0, count = 0;
for (int num : nums) {
    sum += num;
    count += prefix.getOrDefault(sum - goal, 0);
    prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
}
return count;
 */
