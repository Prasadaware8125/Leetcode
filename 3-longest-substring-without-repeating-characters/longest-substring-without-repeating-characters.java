class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        int len = 0;

        for( int r = 0 ; r < s.length() ; r++ ) {
            char currChar = s.charAt(r);
            while( charSet.contains(currChar) ) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(currChar);
            len = Math.max(len, r - l + 1 );
        }
        return len;
    }
}