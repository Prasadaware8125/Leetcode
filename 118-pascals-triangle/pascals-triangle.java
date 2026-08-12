class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int[][] res = new int[numRows][numRows];

        for( int i = 0 ; i < numRows ; i++ ) {
            List<Integer> row = new ArrayList<>();
            for( int j = 0 ; j <= i ; j++ ) {
                if( i == j || j == 0 ) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = res[i-1][j-1] + res[i-1][j];
                }
                row.add(res[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }
}