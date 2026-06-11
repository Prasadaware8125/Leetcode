class Solution {
    public boolean validPalindrome(String s) {
        return checkPalindrome(s, 0, s.length()-1, true); 
    }

    public boolean checkPalindrome(String s, int i, int j, boolean flag) {
        while( i < j ) {
            if( s.charAt(i) != s.charAt(j) ) {
                if( flag == true ) {
                    return checkPalindrome(s, i+1, j, false) || checkPalindrome(s, i, j-1, false);
                } else {
                    return false;
                }
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}