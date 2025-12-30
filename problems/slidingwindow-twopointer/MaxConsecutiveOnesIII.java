public class MaxConsecutiveOnesIII {
    // Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
    //increase zero count for every zero in the array
    //if the zero count is greater than k, then move the left pointer to the right
    //if the zero count is less than or equal to k, then update the maxlength
    public int longestOnes(int[] nums, int k) {
        int r= 0 ; int l=0; int maxlength = 0 ; 
        int zerocount=0;
        while(r<nums.length){
            if(nums[r]==0){
               zerocount++; 
            }
            if(zerocount>k){
                if(nums[l]==0){
                    zerocount--;
                }
                l++;
            }
               if(zerocount<=k) {
                maxlength = Math.max(maxlength, r-l+1);
               }
            r++;
        }

        return maxlength;
    }
}
