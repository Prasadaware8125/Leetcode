class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while( l < r ) {
            char leftChar = s.charAt(l);
            char rightChar = s.charAt(r);
            if( !Character.isLetterOrDigit(rightChar) ) {
                    r = r - 1;
                    continue;
            }
            if( !Character.isLetterOrDigit(leftChar) ){
                    l = l + 1;
                    continue;
            }
            if( Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar) ) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}