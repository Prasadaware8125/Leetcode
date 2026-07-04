class Solution {
    static class Edge {
        int dest, wt;

        Edge(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    int min = Integer.MAX_VALUE;

    public void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        vis[curr] = true;

        for (Edge e : graph[curr]) {
            min = Math.min(min, e.wt);

            if (!vis[e.dest]) {
                dfs(graph, vis, e.dest);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        boolean[] vis = new boolean[n + 1];
        
        dfs(graph, vis, 1);
            
        return min;
    }
}