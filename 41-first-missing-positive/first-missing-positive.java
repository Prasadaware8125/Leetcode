class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for( int num : nums ) {
            set.add(num);   // adding all elements to set
        } 

        int n = nums.length;

        for( int i = 1 ; i <= n + 1 ; i++ ) {
            if( !set.contains(i) ) {
                return i;
            }
        }

        return n + 1;
    }
}