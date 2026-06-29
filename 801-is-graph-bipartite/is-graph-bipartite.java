class Solution {
    public boolean isBipartiteUtil(int[][] graph, int[] col, int cu) {
        Queue<Integer> q = new LinkedList<>();
        q.add(cu);
        col[cu] = 0;

        while (q.isEmpty() == false) {
            int curr = q.remove();
            for (int i = 0; i < graph[curr].length; i++) {
                int node = graph[curr][i];
                if (col[node] == -1) {
                    col[node] = col[curr] == 0 ? 1 : 0;
                    q.add(node);
                } else if (col[node] == col[curr]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            col[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] == -1) {
                if (isBipartiteUtil(graph, col, i) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}