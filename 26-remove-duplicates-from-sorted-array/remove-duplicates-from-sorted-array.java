class Solution {
    public static int removeDuplicates(int[] nums) {
        int si = 1;
        int li = 0, ri = 1;
        while( li < ri && ri < nums.length ) {
            if( nums[li] != nums[ri] ) {
                li++;
                si++;
                nums[li] = nums[ri];
            }
            ri++;
        }
        for( int i = si+1 ; i < nums.length ; i++ ) {
            nums[i] = 0;
        }
        return si;
    }
}