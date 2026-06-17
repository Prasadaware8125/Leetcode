class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long size = 0;
        long[] len = new long[n];
        for( int i = 0 ; i < n ; i++ ) {
            char curr = s.charAt(i);
            if( curr == '*' ) {
                size = Math.max(size-1, 0L);
            } else if( curr == '#' ) {
                size = size *2;
            } else if( curr == '%' ) {
            } else {
                size++;
            }
            len[i] = size;
        }

        if( k >= size ) {
            return '.';
        }
        

        for( int i = n-1 ; i >= 0 ; i-- ) {
            char curr = s.charAt(i);
            switch(curr) {
                case '*' : break;
                case '#' : if( k >= len[i] / 2) 
                            k -= len[i] / 2;
                            break;
                case '%' : k = len[i] - 1 - k;
                            break;
                default : 
                            if( len[i] == k + 1)
                                return curr;
            }
        }
        return '.';
    }
}