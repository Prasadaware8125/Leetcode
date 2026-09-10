class Solution {
    public int maxScore(int[] cards, int k) {
        int n = cards.length;
        if( n < k ) return -1;
        int l = 0, r = 0, sum = 0, max = 0;
        for( l = 0  ; l < k ; l++ ) {
            sum += cards[l];
            max = Math.max(max, sum);
        }
        for( r = n-1 ; r > n-k-1 ; r-- ) {
            sum -= cards[--l];
            sum += cards[r];
            max = Math.max(max, sum);
        }
        return max;
    }
}