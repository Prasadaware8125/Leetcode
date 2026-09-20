class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for( int i = 0 ; i < s.length() ; i++ ) {
            int ra = 26 - (s.charAt(i)-'a');
            int product = ra * (i+1);
            sum += product;
        }
        return sum;
    }
}