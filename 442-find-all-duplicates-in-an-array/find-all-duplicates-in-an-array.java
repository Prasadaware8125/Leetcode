class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for( int num : nums ) {
            map.put(num, map.getOrDefault(num,0)+1);

            if( map.get(num) == 2 ) {
                list.add(num);
            }
        }

        return list;


    }
}