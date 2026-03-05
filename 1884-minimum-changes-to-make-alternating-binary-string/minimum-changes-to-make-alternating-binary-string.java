class Solution {
    public int minOperations(String s) {
        int opt1 = 0, opt2 = 0;
        for( int i = 0 ; i < s.length() ; i++ ) {
            char expected1 = i % 2 == 0 ? '0' : '1';    // To check if string is 010101
            char expected2 = i % 2 == 0 ? '1' : '0';    // To check if string is 101010

            if ( s.charAt(i) != expected1 ) opt1++;     // If curr char doesn't mateches then we have to increase the counter operation
            if ( s.charAt(i) != expected2 ) opt2++;     // If curr char doesn't mateches then we have to increase the counter operation
        }
        return Math.min(opt1, opt2);        // Return minimum operations
    }
}