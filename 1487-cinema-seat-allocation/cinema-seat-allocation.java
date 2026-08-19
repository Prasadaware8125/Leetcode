class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int left = 0b11110000;
        int middle = 0b11000011;
        int right = 0b00001111;

        Map<Integer, Integer> occupied = new HashMap<>();

        for( int i = 0 ; i < reservedSeats.length ; i++ ) {
            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];

            if( seat >= 2 && seat <= 9 ) {
                int origin = occupied.containsKey(row) ? occupied.get(row) : 0;

                int value = origin | (1 << (seat - 2));

                occupied.put(row, value);
            }
        }

        int ans = (n - occupied.size()) * 2;
        for( Map.Entry<Integer, Integer> entry : occupied.entrySet() ) {
            int row = entry.getKey();
            int bitmask = entry.getValue();

            if( 
                (bitmask | left ) == left ||
                (bitmask | middle ) == middle ||
                (bitmask | right ) == right
            ) {
                ++ans;
            }
        }
        return ans;
    }
}