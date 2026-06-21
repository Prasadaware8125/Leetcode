class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int bars = 0;
        Arrays.sort(costs);

        for( int i = 0 ; i < costs.length ; i++ ) {
            if( coins < costs[i] ) {
                break;
            }
            bars++;
            coins -= costs[i];
        }

        return bars;
    }
}