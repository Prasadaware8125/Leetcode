class Solution {
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public void create_graph(int[][] edges, ArrayList<Edge> graph) {

        for( int i = 0 ; i < edges.length ; i++ ) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph.add(new Edge(u, v));
        }
    }
    public int find(int x, int[] par) {
        if( x == par[x] ) {
            return x;
        }

        return par[x] = find(par[x], par);
    }

    public void union(int a, int b, int[] par, int[] rank) {
        int parA = find(a, par);
        int parB = find(b, par);

        if( rank[parA] == rank[parB] ) {
            par[parB] = parA;
            rank[parA]++;
        } else if( rank[parA] < rank[parB] ) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1];
        int[] rank = new int[n+1];

        for( int i = 0 ; i < n+1 ; i++ ) {
            par[i] = i;
        }

        ArrayList<Edge> graph = new ArrayList<>();
        create_graph(edges, graph);

        for( int i = 0 ; i < graph.size() ; i++ ) {
            Edge e = graph.get(i);

            int parA = find(e.src, par);
            int parB = find(e.dest, par);

            if( parA != parB ) {
                union(e.src, e.dest, par, rank);
            } else if( parA == parB ) {
                return new int[] {e.src, e.dest};
            }
        }

        return new int[] {-1, -1};

    }
}