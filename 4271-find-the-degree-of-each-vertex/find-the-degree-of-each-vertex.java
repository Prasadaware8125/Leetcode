class Solution {
    public int[] findDegrees(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m];
        for( int i = 0 ; i < m ; i++ ) {
            int count = 0;
            for( int j = 0 ; j < n ; j++ ) {
                if( matrix[i][j] != 0 ) {
                    count++;
                }
            }
            ans[i] = count;
        }

        return ans;
    }
}