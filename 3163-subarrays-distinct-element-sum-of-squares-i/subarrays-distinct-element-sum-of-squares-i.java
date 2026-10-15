class Solution {
    public int sumCounts(List<Integer> nums) {
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            hs = new HashSet<>();
            for (int j = i; j < n; j++) {
                hs.add(nums.get(j));
                count += (hs.size() * hs.size());
            }
        }
        return count;
    }
}