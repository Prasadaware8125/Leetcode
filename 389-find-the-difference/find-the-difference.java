class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for( int i = 0 ; i < t.length() ; i++ ) {
            char curr = t.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }
        char ans = 'a';
        for( int i = 0 ; i < s.length() ; i++ ) {
            char curr = s.charAt(i);
            map.put(curr, map.get(curr)-1);
            if( map.get(curr) == 0 ) {
                map.remove(curr);
            }
        }
        int max = Integer.MIN_VALUE;
        for( Character key : map.keySet() ) {
            int value = map.get(key);
            if( max < value) {
                max = value;
                ans = key;
            }
        }

        return ans;
    }
}