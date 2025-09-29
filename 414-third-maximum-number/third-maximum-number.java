class Solution {
    public int thirdMax(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;
        int res[] = new int[3];

        for( Integer num : nums ) {

            if( num.equals(first) || num.equals(second) || num.equals(third) ) {
                continue;
            }   // For overcome the repetions or duplicate values

            if( first == null || first < num ) {
                third = second;
                second = first;
                first = num;
            } else if( second == null || second < num ) {
                third = second;
                second = num;
            } else if( third == null || third < num ) {
                third = num;
            }
        }
        if( third == null ) {
            return first;
        }
        // return third == Integer.MIN_VALUE ? (int) first : (int) third;
        return third;
    }
}