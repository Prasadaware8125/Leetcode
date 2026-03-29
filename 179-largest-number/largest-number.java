class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> str = new ArrayList<>();

        for( int i = 0 ; i < nums.length ; i++ ) {
            str.add(String.valueOf(nums[i]));
        }

        Collections.sort( str, (s1, s2) -> {
            return (s2+s1).compareTo(s1+s2);
        });

        StringBuilder sb = new StringBuilder();

        for( int i = 0 ; i < str.size() ; i++ ) {
            sb.append(str.get(i));
        }

        String ans = sb.toString();
        if( ans.charAt(0) == '0' ) {
            return "0";
        } else {
            return ans;
        }
    }
}