
public class MaximumPointsFromCards {
    // We either pick cards from the start or the end, so we consider all combinations by sliding a window from both ends.
    // lsum keeps track of sum of cards taken from the left, rsum keeps track of cards taken from the right.
    // We keep track of the maximum sum by adjusting the window accordingly.
    public int maxScore(int[] cardPoints, int k) {
        
        int lsum = 0 ; int rsum = 0 ; int maxSum = 0 ; 
        for(int i = 0 ; i <k;i++){
            lsum = lsum+cardPoints[i];
            maxSum = lsum;
        }
        int rindex=cardPoints.length- 1; 
        for(int i=k-1;i>=0;i--){
           
            lsum = lsum - cardPoints[i];
            rsum = rsum+cardPoints[rindex];
             
            maxSum = Math.max(maxSum,lsum+rsum);
            rindex--;
        }
        return maxSum; 
    }
}
