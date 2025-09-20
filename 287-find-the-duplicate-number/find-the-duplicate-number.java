class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();    // to maintain the freq of elements

        for( int num : nums ) {
            if( map.containsKey(num) ) {   
                return num; // if an element occurs more than one time return that ele
            }
            map.put(num,1); // adding elemnts to map
        }
        return -1;  // return -1 if array contains only unique elements i.e not duplicate
    }
}