class Solution {
    static class Point implements Comparable<Point> {
        int i, x, y, distSq;
        Point(int i, int x, int y, int distSq) {
            this.i = i;
            this.x = x;
            this.y = y;
            this.distSq = distSq;
        }

        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for( int i = 0 ; i < points.length ; i++ ) {
            int distSq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new Point(i, points[i][0], points[i][1], distSq));
        }
        int[][] res = new int[k][2];
        for(int i = 0 ; i < k ; i++ ) {
            res[i][0] = pq.peek().x; 
            res[i][1] = pq.peek().y;
            pq.remove(); 
        }
        return res;
    }
}