class Solution {
    public int maxSubArray(int[] nums) {
        // TC : O(n)
        // SC : O(1)
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for( int num : nums ) {
            sum += num;
            maxSum = Math.max( maxSum, sum );   // max sum maintaining
            sum = sum < 0 ? sum = 0 : sum;  // If sum goes in negative then make it 0
        }

        return maxSum;
    }
}