class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;     // Initially we are having ans as the total no. of bottles
        int emptyBottles = numBottles;  // and we will drink all the given bottles first 
        while( emptyBottles >= numExchange ) {
            emptyBottles -= numExchange;    // we will exhange the empty bottles with one full bottle at a time
            numExchange++;  // now the price for one full bottle will increase by one
            ans++;  // adding one bottle in ans
            emptyBottles++; // now will drink another bottle and make it empty 
        }
        // when no. of empty bottles < numExhange return ans as we can't do exchange
        return ans;
    }
}