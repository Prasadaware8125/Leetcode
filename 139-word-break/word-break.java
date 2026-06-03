class Solution {
    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for( int i = 0 ; i < 26 ; i++ ) {
                children[i] = null;
            }
        }
    }
    public Node root = new Node();
    HashMap<String, Boolean> map = new HashMap<>();

    public void insert(String word) {
        Node curr = root;
        for( int i = 0 ; i < word.length() ; i++ ) {
            int idx = word.charAt(i) - 'a';
            if( curr.children[idx] == null ) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public boolean search(String key) {
        Node curr = root;
        for( int i = 0 ; i < key.length() ; i++ ) {
            int idx = key.charAt(i) - 'a';
            if( curr.children[idx] == null ) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public boolean wordBreaker(String key) {
        if( key.length() == 0 ) return true;

        if( map.containsKey(key) ) {
            return map.get(key);
        }

        for( int i = 0 ; i <= key.length() ; i++ ) {
            if( search(key.substring(0, i)) && wordBreaker(key.substring(i)) ) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        for( String word : wordDict ) {
            insert(word);
        }

        return wordBreaker(s);
    }
}