class Solution {
    public String removeOuterParentheses(String s) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for( int i = 1 ; i < s.length()-1 ; i++ ) {
            char curr = s.charAt(i);
            if( curr == '(' && idx++ >= 0 || curr == ')' && --idx >= 0 ) {
                sb.append(curr);
            } 
        }
        return sb.toString();
    }
}