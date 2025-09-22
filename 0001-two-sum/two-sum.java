class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = 1;  // Initailizing pointers
        int res[] = {-1, -1};   // Create array to store the index 
        while( left < right && right < nums.length ) {
            int sum = nums[left] + nums[right];
            if( sum == target ) {
                res[0] = left;
                res[1] = right;
                return res;
            }
            if( (right + 1) != nums.length ) {
                right++;    // Increasing the right pointer until it become equals to lenght of array
            } else {
                left = left + 1;    // when right pointer exeted the length then increase the left pointer by 1
                right = left + 1;   // next make right pointer next to the left right 
            }
        }
        return res; // if the result not exist rturn -1, -1 pointers
    }
}