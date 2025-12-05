class Solution {
    public int countPartitions(int[] nums) {
        // Forward sum
        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];
        for( int i = 1 ; i < nums.length ; i++  ) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        if( prefix[nums.length-1] % 2 != 0 ) {
            return 0;
        }
        // Backward sum
        int suffix[] = new int[nums.length];
        suffix[nums.length-1] = nums[nums.length-1];
        for( int i = nums.length-2 ; i >= 0 ; i-- ) {
            suffix[i] = suffix[i+1] + nums[i];       
        }

        int sum =0, count =0;
        for(int i = 0 ; i < nums.length-1 ; i++ ) {
            sum = prefix[i]+suffix[i+1];
            if(sum %2 == 0) count++;    // even sum
        }

        return count;
    }
}