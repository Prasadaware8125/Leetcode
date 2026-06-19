class Solution {
    public int largestAltitude(int[] gain) {
        int[] prefix = new int[gain.length+1];
        prefix[0] = 0;
        prefix[1] = gain[0];
        int max = 0;
        for( int i = 1 ; i < gain.length ; i++ ) {
            prefix[i+1] = prefix[i] + gain[i];
        }

        for( int i = 0 ; i < prefix.length ; i++ ) {
            max = Math.max(max, prefix[i]);
        }

        return max;
    }
}