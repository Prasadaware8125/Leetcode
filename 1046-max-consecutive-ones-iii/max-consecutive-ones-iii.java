class Solution {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        if( n < k ) return -1;
        int maxLen = 0, zeros = 0;
        int l = 0, r = 0;
        while (r < n) {
            if( arr[r] == 0 ) zeros++;
                while (zeros > k) {
                if( arr[l] == 0 ) {
                    zeros--;
                }
                l++;
            }
            if( zeros <= k ) {
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}