class Solution {
    public void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgCol, int n, int m ) {
        if( sr < 0 || sc < 0 || sr >= n || sc >= m || image[sr][sc] != orgCol || vis[sr][sc] ) {
            return;
        }

        image[sr][sc] = color;
        vis[sr][sc] = true;
        // if( sr-1 >= 0 && sc-1 >= 0 && sr+1 < n && sc+1 < m ) {
            helper(image, sr, sc-1, color, vis, orgCol, n, m);
            helper(image, sr, sc+1, color, vis, orgCol, n, m);
            helper(image, sr+1, sc, color, vis, orgCol, n, m);
            helper(image, sr-1, sc, color, vis, orgCol, n, m);
        // }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];

        helper(image, sr, sc, color, vis, image[sr][sc], n, m);
        return image;
    }
}