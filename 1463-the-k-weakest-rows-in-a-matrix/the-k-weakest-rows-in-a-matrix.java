class Solution {
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if( this.soldiers == r2.soldiers ) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        // Create a pq to store the rows in ascending order of number of soldiers or if num of soldiers is equal then by i < j
        PriorityQueue<Row> pq = new PriorityQueue<>();
        int[] res = new int[k];

        // Adding / building pq
        for( int i = 0 ; i < mat.length ; i++ ) {
            int soldiers = 0;
            for( int j = 0 ; j < mat[0].length ; j++ ) {
                // Calculating number of soldiers in a row
                soldiers += mat[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(soldiers, i));
        }

        // poping the index of K weakese soldiers
        for( int i = 0 ; i < k ; i++ ) {
            res[i] = pq.remove().idx;
        }

        return res;
    }
}