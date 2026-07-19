class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];

        // Store last occurrence of every character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            // Skip if already included
            if (visited[curr - 'a']) {
                continue;
            }

            // Remove larger characters if they appear later
            while (!st.isEmpty()
                    && st.peek() > curr
                    && last[st.peek() - 'a'] > i) {

                visited[st.pop() - 'a'] = false;
            }

            st.push(curr);
            visited[curr - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        for (char ch : st) {
            ans.append(ch);
        }

        return ans.toString();
    }
}