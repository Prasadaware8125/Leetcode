class Solution {
    public int maxProduct(int n) {
        String num = String.valueOf(n);
        int maxProduct = 0;
        for( int i = 0 ; i < num.length() ; i++ ) {
            for( int j = 0 ; j < num.length() ; j++ ) {
                if( i != j ) {
                    int product = ('0' - num.charAt(i)) * ('0' - num.charAt(j));
                    maxProduct = Math.max(product, maxProduct);
                }
            }
        }
        return maxProduct;
    }
}