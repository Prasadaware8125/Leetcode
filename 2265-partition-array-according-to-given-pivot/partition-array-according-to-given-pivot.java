class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> sm = new ArrayList<>();
        ArrayList<Integer> eq = new ArrayList<>();
        ArrayList<Integer> gr = new ArrayList<>();

        for( int num : nums ) {
            if( num < pivot ) {
                sm.add(num);
            } else if( num == pivot ) {
                eq.add(num);
            } else {
                gr.add(num);
            }
        }

        int k = 0;

        for( Integer num : sm ) nums[k++] = num;
        for( Integer num : eq ) nums[k++] = num;
        for( Integer num : gr ) nums[k++] = num;
    
        return nums;
    }
}