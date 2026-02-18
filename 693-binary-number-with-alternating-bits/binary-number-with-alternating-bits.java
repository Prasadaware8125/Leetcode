class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);       // let n = 11 -> bits = 1011 so n >> 1 = 0101 and (n ^ (n>>1)) = 1110 = 14
        return (x & (x+1)) == 0;    // so 1110 & 1111 != 0 so number 11 does not have alternating bits
    }
}