class Solution {
    public int bitwiseComplement(int n) {
        if( n == 0 ) return 1;
        int bits = (int)Math.floor(Math.log(n) / Math.log(2)+1);    // 3 bits required for n = 5
        int bitmask = (1 << bits) - 1;    // 111
        return n ^ bitmask;     // 101 ^ 111 = 010 --> 2
    }
}