class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for( int i = 0 ; i < s.length() ; i++ ) {
            char curr = s.charAt(i);
            if( curr == '*' ) {
                if( result.length() == 0 ) continue;
                result.deleteCharAt(result.length()-1);
            } else if( curr == '#' ) {
                result.append(result);
            } else if( curr == '%' ) {
                result.reverse();
            } else {
                result.append(curr);
            }
        }

        return result.toString();
    }
}