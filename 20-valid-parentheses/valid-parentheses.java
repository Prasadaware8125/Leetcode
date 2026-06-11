class Solution {
    public boolean isValid(String s) {
        if( s.length() < 2 ) return false;
        Stack<Character> st = new Stack<>();
        for( int i = 0 ; i < s.length() ; i++ ) {
            char curr = s.charAt(i);
            if( curr == '(' || curr == '{' || curr == '[' ) {
                st.push(curr);
            } else {
                if( !st.isEmpty() ) {
                    if ( curr == ')' && st.peek() == '(' ) {
                        st.pop();
                    } else if ( curr == '}' && st.peek() == '{' ) {
                        st.pop();
                    } else if ( curr == ']' && st.peek() == '[' ) {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}