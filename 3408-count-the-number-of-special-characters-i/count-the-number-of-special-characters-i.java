class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for( int i = 0 ; i < word.length() ; i++ ) {
            char curr = word.charAt(i);
            if( map.containsKey(curr) ) {
                map.put(curr, map.get(curr)+1);
            }else if( Character.isLowerCase(curr) ) {
                map.put(curr, 1);
            }
        }

        for( int i = 0 ; i < word.length() ; i++ ) {
            char curr = word.charAt(i);
            char lower = Character.toLowerCase(curr);
            if( !Character.isLowerCase(curr) && map.containsKey(lower) && map.get(lower) > 0 ) {
                count++;
                map.put(lower, 0);
            }
        }

        return count;
    }
}