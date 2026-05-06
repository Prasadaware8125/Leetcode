class Solution {
    public int removeDuplicates(int[] nums) {
        // at least 2 
        int k = 2;
        for( int i = 2 ; i < nums.length ; i++ ) {
            if( nums[i] != nums[k-2] ) {
                nums[k] = nums[i];
                k++;
            }
        }
        return nums.length <= 2 ? nums.length : k;
    }
}