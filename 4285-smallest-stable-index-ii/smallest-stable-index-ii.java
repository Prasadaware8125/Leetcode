class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for( int i = n-2 ; i >= 0 ; i-- ) {
            suffix[i] = Math.min(suffix[i+1], nums[i]);
        }

        int leftMax = Integer.MIN_VALUE;
        int stableIndex = Integer.MAX_VALUE;

        for( int i = 0 ; i < n ; i++ ) {
            leftMax = Math.max(leftMax, nums[i]);
            if( Math.abs(leftMax - suffix[i]) <= k ) {
                stableIndex = Math.min(stableIndex, i);
            }
        }

        return stableIndex == Integer.MAX_VALUE ? -1 : stableIndex;
    }
}