class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for( int i = 0 ; i < s.length() ; i++ ) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }

        for( int i = 0 ; i < t.length() ; i++ ) {
            char curr = t.charAt(i);
            if( map.containsKey(curr) ) {
                if( map.get(curr) == 1 ) {
                    map.remove(curr);
                } else {
                    map.put(curr, map.get(curr)-1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }
}