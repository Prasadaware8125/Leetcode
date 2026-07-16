class Solution {
    public int gcd(int a, int b) {
        while( b != 0 ) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int mxi = nums[0];
        for( int i = 0 ; i < n ; i++ ) {
            mxi = Math.max(mxi, nums[i]);
            prefixGcd[i] = gcd(mxi, nums[i]);
        }
        Arrays.sort(prefixGcd);
        int l = 0, r = n-1;
        long sumGcd = 0;
        
        while( l < r ) {
            sumGcd += gcd(prefixGcd[l], prefixGcd[r]);
            l++;
            r--;
        }
        return sumGcd;
    }
}