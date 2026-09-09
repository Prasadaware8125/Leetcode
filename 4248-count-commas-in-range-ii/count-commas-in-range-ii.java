class Solution {
    public long countCommas(long n) {
        long res = 0, p = 1000;
        while( p <= n ) {
            res += n - p +1;
            p = p * 1000;
        }
        return res;
    }
}