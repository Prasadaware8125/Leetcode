class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for( int num : nums1 ) {
            if( !map.containsKey(num) ) {
                map.put(num, 1);
            }
        }
        for( int num: nums2 ) {
            if( map.containsKey(num) && map.get(num) == 1 ) {
                map.put(num, 0);
                list.add(num);
            }
        }

        int[] res = new int[list.size()];
        for( int i = 0 ; i < list.size() ; i++ ) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}