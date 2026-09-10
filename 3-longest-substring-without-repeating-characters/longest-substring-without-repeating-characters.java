class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = 256, l = 0 , r = 0, maxLen = 0;
        int len = s.length();
        int[] map = new int[size];
        for( int i = 0 ; i < size ; i++ ) {
            map[i] = -1;
        }
        while( r < len ) {
            char curr = s.charAt(r);
            if( map[curr] != -1 ) {
                if( map[curr] >= l ) {
                    l = map[curr]+1;
                }
            }
            maxLen = Math.max(maxLen, r-l+1);
            map[curr] = r;
            r++;
        }
        return maxLen;
    }
}