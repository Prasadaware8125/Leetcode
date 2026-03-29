class Solution {
    public int findClosest(int x, int y, int z) {
        if( x == y ) return 0;
        int xdist = Math.abs( x - z );
        int ydist = Math.abs( y - z );
        if( xdist == ydist ) return 0;
        if( xdist < ydist ) return 1;

        return 2;
    }
}