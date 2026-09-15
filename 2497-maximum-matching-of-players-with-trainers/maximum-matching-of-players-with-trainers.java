class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count = 0;
        int i = 0;
        for( int j = 0 ; j < trainers.length ; j++ ) {
            if( i < players.length && trainers[j] >= players[i] ) {
                count++;
                i++;
            }
        }
        return count;
    }
}