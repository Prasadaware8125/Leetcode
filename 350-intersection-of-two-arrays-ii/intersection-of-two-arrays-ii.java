class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> li = new ArrayList<>();

        for( int num : nums1 ) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for( int num : nums2 ) {
            if( map.containsKey(num) && map.get(num) > 0 ) {
                li.add(num);
                map.put(num, map.get(num)-1);
            }
        }
        int[] res = new int[li.size()];
        int i = 0;
        for( Integer num : li ) {
            res[i++] = num;
        }

        return res;
    }
}