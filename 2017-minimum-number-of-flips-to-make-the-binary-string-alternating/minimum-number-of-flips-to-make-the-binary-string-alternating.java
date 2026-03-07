class Solution {
    public int minFlips(String s) {
        int n = s.length();     // Length

        int result = Integer.MAX_VALUE;     // To store minimum flips required
        int flip1 = 0;  // 101010 pattern 1
        int flip2 = 0;  // 010101 pattern 2
        int i = 0, j = 0;   // Sliding window pointers

        while( j < 2*n) {   // Iterate till 2*n because rotation can create n different windows
            char expectedCharS1 = j % 2 == 0 ? '1' : '0';   // 101010
            char expectedCharS2 = j % 2 == 0 ? '0' : '1';   // 010101
            if(s.charAt(j%n) != expectedCharS1 ) {      // if current character doesn't match we need to flip to match with pattern 1
                flip1++;
            }
            if(s.charAt(j%n) != expectedCharS2 ) {      // if current character doesn't match we need to flip to match with pattern 2
                flip2++;
            }
            if( j-i+1 > n ) {       // If window size becomes larger than n, remove the effect of the leftmost character
                char remove1 = i % 2 == 0 ? '1' : '0';
                char remove2 = i % 2 == 0 ? '0' : '1';

                if(s.charAt(i%n) != remove1 ) {     // if the removed left char contributed to flip 1, remove it for pattern 1
                    flip1--;
                }
                if(s.charAt(i%n) != remove2 ) {     // if the removed left char contributed to flip 2, reomve it for pattern 2
                    flip2--;
                }
                i++;    // move window start
            }
            // When window size becomes exactly n, this represents one possible rotation
            if( j-i+1 == n ) {
                result = Math.min(result, Math.min(flip1, flip2));
            }
            j++;    // expand window
        }
        return result;
    }
}