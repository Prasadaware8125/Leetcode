class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int left = 0, right = 0, n = s.length();
        StringBuilder sb = new StringBuilder("");
        boolean flag = false;
        while( right < n ) {
            if( flag == false ) {
                char curr = s.charAt(right);
                sb.append(curr);
            }
            if( (sb.indexOf("a") != -1) && (sb.indexOf("b") != -1) && (sb.indexOf("c") != -1)) {
                count += (n-right);
                sb.deleteCharAt(0);
                left++;
                flag = true;
            } else {
                right++;
                flag = false;
            }
        }
        
        return count;
    }
}