class Solution {
    public int binaryGap(int n) {
        int count = 0, maxCount = 0;
        while( n > 0 ) {
            if( (n & 1) == 1) {
                count =1;
                n = n >> 1;
                while( n > 0 && (n & 1) != 1) {
                    count++;
                    n = n>>1;
                }
                if( n > 0 ) {
                    maxCount = Math.max(maxCount, count);
                }
                count = 0;
                continue;
            }
            n = n>>1;
        }
        return maxCount;
    }
}