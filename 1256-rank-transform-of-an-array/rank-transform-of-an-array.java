class Solution {
    static class Info{
        int rank, freq;
        public Info(int r, int f) {
            this.rank = r;
            this.freq = f;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] copy = new int[n];
        for( int i = 0 ; i < n ; i++ ) {
            copy[i] = arr[i];
        }

        Arrays.sort(copy);
        int rank = 1;
        HashMap<Integer, Info> map = new HashMap<>();
        for(int curr : copy ) {
            if( map.containsKey(curr) ) {
                map.put(curr, new Info(map.get(curr).rank, map.get(curr).freq+1));
            } else {
                map.put(curr, new Info(rank++, 1));
            }
        }
        for( int i = 0 ; i < n ; i++ ) {
            int curr = arr[i];
            if( map.containsKey(curr) ) {
                arr[i] = map.get(curr).rank;
                if( map.get(curr).freq == 1 ) {
                    map.remove(curr);
                } else {
                    map.put(curr, new Info(map.get(curr).rank, map.get(curr).freq-1));
                }
            }
        }

        return arr;
    }
}