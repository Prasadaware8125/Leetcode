class Solution {
    static class Edge{
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public void create_graph(int[][] prerequisites, ArrayList<Edge>[] graph) {
        for( int i = 0 ; i < graph.length ; i++ ) {
            graph[i] = new ArrayList<>();
        }

        for( int i = 0 ; i < prerequisites.length ; i++ ) {
            int d = prerequisites[i][0];
            int s = prerequisites[i][1];

            graph[s].add(new Edge(s, d));
        }
    }
    public boolean topSort(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> s, boolean[] st, int curr) {
        vis[curr] = true;
        st[curr] = true;
        
        for( int i = 0 ; i < graph[curr].size() ; i++ ) {
            Edge e = graph[curr].get(i);
            if( st[e.dest] ) {
                return true;
            }
            if( vis[e.dest] == false ) {
                if(topSort(graph, vis, s, st, e.dest)) {
                    return true;
                }
            }
        }


        s.push(curr);
        st[curr] = false;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Edge>[] graph = new ArrayList[n];
        create_graph(prerequisites, graph);
        boolean[] vis = new boolean[n];
        boolean[] st = new boolean[n];
        Stack<Integer> s = new Stack<>();
        
        for( int i = n-1 ; i >= 0 ; i-- ) {
            if( vis[i] == false ) {
                if(topSort(graph, vis, s, st, i)) {
                    return new int[0];
                }
            }
        }

        int[] ans = new int[n];
        int idx = 0;
        while (!s.isEmpty() ) {
            int curr = s.pop();
            ans[idx++] = curr;
        }

        return ans;
    }
}