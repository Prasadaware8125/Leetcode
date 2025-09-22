class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();    // for frequency

        for( int num : nums ) {
            if( map.containsKey(num) ) {    // if the element is already present the return true i.e the array contains duplicate elements
                return true;
            }
            map.put(num,1); // if array does not contain the curr element then add it to map
        }

        return false;   // if array contains only unquie elements

    }
}