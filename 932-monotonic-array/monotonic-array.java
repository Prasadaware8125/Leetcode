class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean flag = true;
        if (nums.length == 1)
            return flag;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                flag = false;
                break;
            }
        }

        if( flag == false ) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    flag = false;
                    return flag;
                }
            }
        }
        return true;
    }
}