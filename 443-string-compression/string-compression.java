class Solution {
    public int compress(char[] chars) {
        StringBuilder str = new StringBuilder("");

        for( int i = 0 ; i < chars.length ; i++ ) {
            int count = 0;
            char curr = chars[i];
            while( i < chars.length &&  curr == chars[i] ) {
                count++;
                i++;
            }
            i--;
            str.append(curr);
            if( count > 1 ) {
                str.append(count);
            }
        }

        for( int j = 0 ; j < str.length() ; j++ ) {
            chars[j] = str.charAt(j);
        }

        return str.length();
    }
}