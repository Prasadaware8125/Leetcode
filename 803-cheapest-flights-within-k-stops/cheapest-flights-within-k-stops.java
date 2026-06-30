class Solution {
    static class Info{
        int vertex, cost, stops;
        public Info(int v, int c, int s) {
            this.vertex = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        for( int i = 0 ; i < n ; i++ ) {
            if( i != src ) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while( !q.isEmpty() ) {
            Info curr = q.remove();
            if( curr.stops > k ) {
                continue;
            }

            for( int i = 0 ; i < flights.length ; i++ ) {
                int u = flights[i][0];
                int v = flights[i][1];
                int p = flights[i][2];

                if( curr.vertex == u && curr.cost + p < dist[v] ) {
                    dist[v] = curr.cost + p;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}