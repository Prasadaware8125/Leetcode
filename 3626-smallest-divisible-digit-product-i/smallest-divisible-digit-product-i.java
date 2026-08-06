class Solution {
    public int product(int n) {
        int ans = 1;
        while( n > 0 ) {
            int rem = n % 10;
            if( rem == 0 ) return 0;
            ans = ans * rem;
            n = n / 10;
        }
        return ans;
    }
    public int smallestNumber(int n, int t) {
        int ans = 0;
        int pr = product(n);
        int ns = n;
        while( pr % t != 0 ) {
            pr = product(++ns);
        }
        return ns;
    }
}