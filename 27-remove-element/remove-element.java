class Solution {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;
        for( int num : nums ) {
            if( num != val ) {
                count++;
                arr.add(num);
            }
        }

        for( int i = 0 ; i < arr.size() ; i++ ) {
            nums[i] = arr.get(i);
        }

        return count;
    }
}