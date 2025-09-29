class Solution {
    public int thirdMax(int[] nums) {
        // Remove duplicates first
        int[] unique = java.util.Arrays.stream(nums).distinct().toArray();
        
        if (unique.length < 3) {
            // Return the maximum
            int max = unique[0];
            for (int x : unique) max = Math.max(max, x);
            return max;
        }
        
        // Otherwise find 3rd max using QuickSelect
        return select(unique, unique.length, 3);
    }

    public int select(int[] a, int n, int k) {
        int low = 0, up = n;
        while (low < up) {
            int j = partition(a, low, up);
            int rank = j - low + 1;
            if (rank == k) return a[j];
            else if (rank < k) { k -= rank; low = j + 1; }
            else up = j;
        }
        return -1;
    }

    public int partition(int[] a, int m, int p) {
        int v = a[m], i = m, j = p - 1;
        while (i < j) {
            while (i < p && a[i] >= v) i++;
            while (a[j] < v) j--;
            if (i < j) interchange(a, i, j);
        }
        interchange(a, m, j);
        return j;
    }

    public void interchange(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
