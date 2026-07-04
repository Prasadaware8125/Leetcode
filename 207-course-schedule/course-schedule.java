class Solution {
    static class Edge{
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    public void create_graph(int[][] prerequisites, ArrayList<Edge>[] graph, int V) {
        for( int i = 0 ; i < V ; i++ ) {
            graph[i] = new ArrayList<>();
        }

        for( int i = 0 ; i <  prerequisites.length ; i++ ) {
            int d = prerequisites[i][0];
            int s = prerequisites[i][1];

            graph[s].add(new Edge(s, d));
        }
    }

    public boolean topSort(ArrayList<Edge>[] graph, boolean[] vis, boolean[] s, int curr) {
        vis[curr] = true;
        s[curr] = true;

        for( int i = 0 ; i < graph[curr].size() ; i++ ) {
            Edge e = graph[curr].get(i);
            if( s[e.dest] ) {
                return true;
            }
            if( !vis[e.dest] ) {
                if( topSort(graph, vis, s, e.dest) ) {
                    return true;    // cycle exists
                }
            }
        }
        s[curr] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int V = numCourses;
        ArrayList<Edge>[] graph = new ArrayList[V];
        create_graph(prerequisites, graph, V);
        boolean[] vis = new boolean[V];
        boolean[] s = new boolean[V];

        for( int i = 0 ; i < V ; i++ ) {
            if( !vis[i] ) {
                if(topSort(graph, vis, s, i)) {
                    return false;    // cycle exists
                }
            }
        }

        return true;
    }
}