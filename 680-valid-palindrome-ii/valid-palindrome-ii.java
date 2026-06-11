class Solution {
    public boolean check(String s) {
        boolean change = false;
        int l = 0, r = s.length()-1;
        while( l <= r ) {
            if( s.charAt(l) == s.charAt(r) ) {
                l++;
                r--;
            } else if( change == false && s.charAt(l) == s.charAt(r-1) ) {
                r--;
                change = true;
            } else if( change == false && s.charAt(l+1) == s.charAt(r) ) {
                l++;
                change = true;
            } else {
                return false;
            }
        }

        return true;
    }
    public boolean validPalindrome(String s) {
        boolean change = false;
        int l = 0, r = s.length()-1;
        while( l <= r ) {
            if( s.charAt(l) == s.charAt(r) ) {
                l++;
                r--;
            } else if( change == false && s.charAt(l+1) == s.charAt(r) ) {
                l++;
                change = true;
            } else if( change == false && s.charAt(l) == s.charAt(r-1) ) {
                r--;
                change = true;
            } else {
                return check(s);
            }
        }

        return true;
    }
}