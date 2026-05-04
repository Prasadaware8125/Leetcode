class Solution {
    public void transpose(int[][] matrix) {
        for( int i = 0 ; i < matrix.length ; i++ ) {
            for( int j = i+1 ; j < matrix.length ; j++ ) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        int n = matrix.length-1;

        // swapping the elements of rows
        for( int i = 0 ; i < matrix.length ; i++ ) {
            int left = 0;
            int right = n;
            while( left < right ) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}