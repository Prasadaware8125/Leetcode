class Solution {
    public int maxProduct(int[] nums) {
        int product = 0;
        int l = 0, r = nums.length-1;

        while( l < r ) {
            int pr = (nums[l]-1) * (nums[r]-1);
            product = Math.max(product, pr);

            if( nums[l] < nums[r] ) {
                l++;
            } else {
                r--;
            }
        }
        return product;
    }
}