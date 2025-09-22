class Solution {
    public int subarraySum(int[] nums, int k) {
        int l = 0, r = 0;
        int count = 0, sum = 0;
        while( r < nums.length ) {
            sum += nums[r];
            if( sum == k ) {
                count++;
            }
            if( r+1 != nums.length ) {
                r++;
            } else {
                sum = 0;
                l++;
                r = l;
            }
        }
        return count;
    }
}