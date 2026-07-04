class Solution {
    static class Edge{
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public void create_graph(int[][] graph, ArrayList<Edge>[] g, int V) {
        for( int i = 0 ; i < V ; i++ ) {
            g[i] = new ArrayList<>();
        }

        for( int i = 0 ; i < V ; i++ ) {
            for( int j = 0 ; j < graph[i].length ; j++ ) {
                g[i].add(new Edge(i, graph[i][j]));
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] g, int src, int dest, List<Integer> row, List<List<Integer>> ans) {
        row.add(src);
        if( src == dest ) {
            ans.add(new ArrayList<>(row));
            row.remove(row.size()-1);
            return;
        }

        for( int i = 0 ; i < g[src].size() ; i++ ) {
            Edge e = g[src].get(i);
            dfs(g, e.dest, dest, row, ans); 
        }
        row.remove(row.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int V = graph.length;
        ArrayList<Edge>[] g = new ArrayList[V];
        create_graph(graph, g, V);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        dfs(g, 0, V-1, row, ans);
        return ans;
    }
}