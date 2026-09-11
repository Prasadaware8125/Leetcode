class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0, r = 0, n = fruits.length;
        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0)+1);
            while( map.size() >= 3 ) {
                map.put(fruits[l], map.get(fruits[l])-1);
                if( map.get(fruits[l]) == 0 ) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}