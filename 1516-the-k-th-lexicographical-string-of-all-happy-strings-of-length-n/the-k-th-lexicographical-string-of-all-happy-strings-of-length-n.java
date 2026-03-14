class Solution {
    String res = "";
    int count = 0;
    // Recursion and backtracking
    public void solve(int n, StringBuilder curr, int k) {
        if( curr.length() == n ) {
            count++;
            if( count == k ) {
                res = curr.toString();
            }
            return;
        }
        for( char ch = 'a' ; ch <= 'c' ; ch++ ) {
            if( !curr.isEmpty() && curr.charAt(curr.length()-1) == ch ) {
                continue;
            }

            // Do
            curr.append(ch);

            // Explore
            solve(n, curr, k);

            // Undo
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public String getHappyString(int n, int k) {
        StringBuilder curr = new StringBuilder("");
        solve(n, curr, k);

        return res;
    }
}