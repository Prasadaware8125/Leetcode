class Solution {
    public int countCollisions(String directions) {
        int count = 0;
        int ans = 0;
        boolean flag = false;

        for( int i = 0 ; i < directions.length() ; i++ ) {
            if( directions.charAt(i) == 'R' ) {
                count++;
            } else if( directions.charAt(i) == 'L' ) {
                if( flag && count == 0 ) {
                    ans += 1;
                } else if( count > 0 ) {
                    ans += count+1;
                    count = 0;
                    flag = true;
                }
            } else {
                flag = true;
                if( count > 0 ) {
                    ans += count;
                    count = 0;
                }
            }
        }
        return ans;
    }
}