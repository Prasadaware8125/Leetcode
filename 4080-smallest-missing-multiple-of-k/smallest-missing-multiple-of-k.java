class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for( int i = 0 ; i < nums.length ; i++ ) {
            if( nums[i] % k == 0 ) {
                map.put(i, nums[i]);
            }
        }

        for( int i = 1 ; i < 101 ; i++ ) {
            if( !map.containsValue(k*i) ) {
                return k*i;
            }
        }
        return k*101;
    }
}