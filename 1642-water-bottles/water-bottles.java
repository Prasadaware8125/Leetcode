class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {  // numBottles = 15 and numExchange = 4
        int ans = numBottles;
        while( numBottles >= numExchange ) {
            int newBottles = numBottles / numExchange; // int 1st iteration it will be 3 // 2nd it will be 1
            int remBottles = numBottles % numExchange; // int 1st iteration it will be 3 // in 2nd it will be 2
            ans = ans + newBottles; // it will 15 + 3 = 18 // it will be 18 + 1 = 19
            numBottles = newBottles + remBottles; // it will be 3 + 3 = 6 // it will be 1 + 2 = 3
        }
        return ans; // at last ans = 19
    }
}