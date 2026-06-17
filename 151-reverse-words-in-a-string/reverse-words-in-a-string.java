class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        for( int i = 0 ; i < s.length() ; i++ ) {
            StringBuilder sb = new StringBuilder();
            while( i < s.length() && s.charAt(i) != ' ' ) {
                sb.append(s.charAt(i));
                i++;
            }

            if( sb.length() > 0 ) {
                st.push(sb.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while( !st.isEmpty() ) {
            res.append(st.pop());
            res.append(' ');
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();


    }
}