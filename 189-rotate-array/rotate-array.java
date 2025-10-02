class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;    // eg. if k = 3 then k % length = 3
        reverse(nums, 0, nums.length-1);    // reverse the whole array
        reverse(nums, 0, k-1);  // reverse the k elemente that are at the begining of array
        reverse(nums, k, nums.length-1);    // reverse the reamining part of the array
    }


    public void reverse(int[] nums, int start, int end) {   // method to reverse an array
        while( start <= end ) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}