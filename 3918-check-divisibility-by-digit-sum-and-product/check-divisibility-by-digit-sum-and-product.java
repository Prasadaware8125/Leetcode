class Solution {
    public boolean checkDivisibility(int n) {
        int num = n, sum = 0, product = 1;
        while( num > 0 ) {
            int rem = num % 10;
            sum += rem;
            product *= rem;
            num /= 10;
        }
        return (n % (sum+product) == 0 ? true : false);
    }
}