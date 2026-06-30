class Solution {
    static class Edge{
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public void create_graph(int[][] edges, ArrayList<Edge>[] graph) {
        for( int i = 0 ; i < graph.length ; i++ ) {
            graph[i] = new ArrayList<>();
        }

        for( int i = 0 ; i < edges.length ; i++ ) {
            int src = edges[i][0];
            int dest = edges[i][1];

            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src));
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        create_graph(edges, graph);

        boolean[] vis = new boolean[n];
        
        return validPathUtil(graph, vis, source, destination);
    }

    public boolean validPathUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int dest) {
        if( curr == dest ) {
            return true;
        }

        vis[curr] = true;

        for( int i = 0 ; i < graph[curr].size() ; i++ ) {
            Edge e = graph[curr].get(i);
            if( !vis[e.dest] ) {
                if( validPathUtil(graph, vis, e.dest, dest )) {
                    return true;
                }
            }
        }

        return false;
    }
}