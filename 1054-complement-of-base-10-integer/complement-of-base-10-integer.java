class Solution {
    public int bitwiseComplement(int n) {
        int bitmask = 1;
        // eg: 5 --> 101
        while( n > bitmask ) {
            bitmask = bitmask << 1; // 10 , 110
            bitmask = bitmask | 1;  // 11 , 111
        }
        return n ^ bitmask;     // 101 ^ 111 = 010 --> 2
    }
}