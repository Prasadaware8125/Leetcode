class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;  // length of array
        int[] prefix = new int[len];    // array to calculate and store the products from left to right

        prefix[0] = 1;  // first ele is 1

        for( int i = 1 ; i < len ; i++ ) {
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        int[] suffix = new int[len];

        suffix[len-1] = 1;

        for( int i = len-2 ; i >= 0 ; i-- ) {
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        int[] ans = new int[len];

        for( int i = 0 ; i < len ; i++ ) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans; // the array containing the product of array except self
    }
}