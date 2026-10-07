class Solution {
    public int minRotations(String s) {
        int ld = s.charAt(0) - '0', rot = Math.min(ld, 10 - ld), sum = rot;
        for( int i = 1 ; i < s.length() ; i++ ) {
            int curr = s.charAt(i) - '0';
            int d1 = Math.abs(ld-curr);
            // int d2 = Math.abs(10-d1);
            rot = Math.min(d1, 10-d1);
            ld = curr;
            sum += rot;
        }
        return sum;
    }
}