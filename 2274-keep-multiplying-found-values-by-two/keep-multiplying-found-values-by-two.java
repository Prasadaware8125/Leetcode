class Solution {
    public int findFinalValue(int[] nums, int original) {
        // for( int i = 0 ; i < nums.length ; i++ ) {
        //     for( int j = 0 ; j < nums.length ; j++ ) {
        //         if( nums[j] == original ) {
        //             original = 2 * original;
        //         }
        //     }
        // }
        // return original;

        boolean x = true;
        while( x ) {
            x = find(nums,original);
            original = 2 * original;
        }
        return original / 2;
    }

    public boolean find(int[] nums, int original) {
        for( int num : nums ) {
            if( num == original ) {
                return true;
            }
        }
        return false;
    }
}