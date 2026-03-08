class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder res = new StringBuilder("");
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (idx < nums[i].length()) {
                res.append(nums[i].charAt(idx++) == '0' ? '1' : '0');
            } else {
                break;
            }
        }
        return res.toString();
    }
}