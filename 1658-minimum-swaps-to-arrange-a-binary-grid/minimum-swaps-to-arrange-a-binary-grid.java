class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;    // rows = columns
        // Find end zeros = no. of continuos 0s at the end
        int endZeros[] = new int[n];
        for(int i = 0 ; i < n ; i++ ) {
            int j = n-1;
            int count = 0;
            while( j >= 0 && grid[i][j] == 0 ) {
                count++;
                j--;
            }
            endZeros[i] = count;
        }
        // For each row 
        int steps = 0;
        for( int i = 0 ; i < n ; i++ ) {
            // --- check need of 0s by (n-i-1)
            int need = n - i - 1;
            // --- check the nearest row having 0s >= need
            int j = i;
            while( j < n && endZeros[j] < need ) {
                j++;
            }
            if( j == n ) {
                return -1;
            }

            steps += j-i;
            while( j > i ) {
                swap(j, j-1, endZeros);
                j--;
            }

        }
        // -- if not found return -1
        // -- else swapsteps;
        return steps;
    }

    public void swap(int one, int two, int[] endZeros) {
        int temp = endZeros[one];
        endZeros[one] = endZeros[two];
        endZeros[two] = temp;
        return;
    }
}