class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for( int i = 0 ; i < n ; i++ ) {
            graph[i] = new ArrayList<>();
        }
        int[] inDeg = new int[n];

        for( int[] pre : prerequisites ) {
            int course = pre[0];
            int prereq = pre[1];

            graph[prereq].add(course);
            inDeg[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for( int i = 0 ; i < n ; i++ ) {
            if( inDeg[i] == 0 ) {
                q.add(i);
            }
        }

        int[] ans = new int[n];
        int idx = 0;

        while( !q.isEmpty() ) {
            int curr = q.remove();
            ans[idx++] = curr;
            inDeg[curr]--;
            for( int next : graph[curr] ) {
                inDeg[next]--;
                if( inDeg[next] == 0 ) {
                    q.add(next);
                }
            }
        }

        if( idx != n ) {
            return new int[0];
        }
        
        return ans;
    }
}