class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder("");
            int sum = 0, i = 0, j = 0;
            while (i < s.length()) {
                sum = 0;
                j = i;
                while (j < Math.min(s.length(), i+k) ) {
                    sum += s.charAt(j) - '0';
                    j++;
                }
                sb.append(String.valueOf(sum));
                i = i + k;
            }
            s = sb.toString();
        }
        return s;
    }
}