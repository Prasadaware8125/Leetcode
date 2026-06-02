class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int freq = nums.length / 2;
        int maxFreq = 0;
        int ans = nums[0];
        for( int num : nums ) {
            if( hm.containsKey(num) ) {
                hm.put(num, hm.get(num)+1);
                if( maxFreq < hm.get(num) ) {
                    maxFreq = hm.get(num);
                    ans = num;
                }
            } else {
                hm.put(num, 1);
            }
        }

        return maxFreq >= freq ? ans : -1;
    }
}