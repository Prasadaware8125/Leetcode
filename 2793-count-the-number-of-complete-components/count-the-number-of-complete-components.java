class Solution {
    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public void create_graph(int[][] edges, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];

            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src));
        }
    }

    public void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        vis[curr] = true;
        vertices++;
        degreeSum += graph[curr].size();
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, vis, e.dest);
            }
        }
    }

    int vertices = 0, degreeSum = 0;
    public int countCompleteComponents(int n, int[][] edges) {

        ArrayList<Edge>[] graph = new ArrayList[n];
        create_graph(edges, graph);
        int count = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vertices = 0;
                degreeSum = 0;
                dfs(graph, vis, i);
                int edgesInComponent = degreeSum / 2;
                int required = vertices * (vertices - 1) / 2;

                if (edgesInComponent == required) {
                    count++;
                }
            }
        }

        return count;
    }
}