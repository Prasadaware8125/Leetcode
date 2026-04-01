class Solution {
    static class Pair implements Comparable<Pair> {
        int val, idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // Sorting in descending order
            // Priority for maximum element
            return p2.val - this.val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for( int i = 0 ; i < k ; i++ ) {
            pq.add(new Pair(nums[i], i));
        }

        res[0] = pq.peek().val;
        for(int i = k ; i < n ; i++ ) {
            while ( pq.size() > 0 && pq.peek().idx <= (i-k) ) {
                pq.remove();
            }
            pq.add(new Pair(nums[i], i));
            res[i-k+1] = pq.peek().val;
        }

        return res;
    }
}