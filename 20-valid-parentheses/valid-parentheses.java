class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for( int i = 0 ; i < s.length() ; i++ ) {
            char curr = s.charAt(i);
            if( curr == '(' || curr == '{' || curr == '[' ) {
                st.push(curr);
            } else if( !st.isEmpty() ) {
                if( curr == ')' && st.pop() != '(' ) {
                    return false;
                } else if( curr == '}' && st.pop() != '{' ) {
                    return false;
                } else if( curr == ']' && st.pop() != '[' ) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return st.isEmpty() == true ? true : false;
    }
}