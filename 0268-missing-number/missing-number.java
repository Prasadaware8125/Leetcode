class Solution {
    public int missingNumber(int[] nums) {
        int aSum = 0, vSum = 0;
        for( int i = 1 ; i <= nums.length ; i++ ) {
            aSum += i;
        }

        for( int i = 0 ; i < nums.length ; i++ ) {
            vSum += nums[i];
        }

        return aSum - vSum;
    }
}