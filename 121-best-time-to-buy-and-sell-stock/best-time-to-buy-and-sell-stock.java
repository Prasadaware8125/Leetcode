class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, maxProfit = 0, minPrice = prices[0];
        for( int price : prices ) {
            if( minPrice < price ) {    // if the current days price is greater than minPrice till curr day then calculate profit 
                profit = price - minPrice;
                maxProfit = Math.max( profit, maxProfit );
            } else {
                minPrice = price;
            }
        }

        return maxProfit;
    }
}