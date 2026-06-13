class Solution {
    public int strStr(String haystack, String needle) {
        HashMap<StringBuilder, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for( int i = 0 ; i < haystack.length() ; i++ ) {
            if( haystack.charAt(i) == needle.charAt(0) ) {
                int j = i;
                int k = 0;
                while( k < needle.length() && j < haystack.length() && haystack.charAt(j) == needle.charAt(k) ) {
                    j++;
                    k++;
                }
                if( k == needle.length() ) {
                    return i;
                }
            }
        }
        return -1;
    }
}