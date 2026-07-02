class Solution {
    static class Info{
        int r, c, h;
        public Info(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);

        if( startHealth <= 0 ) return false;

        int[][] best = new int[n][m];
        for( int i = 0 ; i < n ; i++ ) {
            for( int j = 0 ; j < m ; j++ ) {
                best[i][j] = -1;
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, startHealth));

        best[0][0] = startHealth;

        while( !q.isEmpty() ) {
            Info curr = q.remove();

            if( curr.r == n-1 && curr.c == m-1 ) {
                return true;
            }

            for( int i = 0 ; i < 4 ; i++ ) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if( nr >= 0 && nr < n && nc >= 0 && nc < m ) {
                    int nextHealth = curr.h - grid.get(nr).get(nc);
                    if( nextHealth > 0 && nextHealth > best[nr][nc] ) {
                        best[nr][nc] = nextHealth;
                        q.add(new Info(nr, nc, nextHealth));
                    }
                }
            }
        }

        return false;
    }
}