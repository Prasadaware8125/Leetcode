class Solution {
    public int findMin(int[] nums) {
        int n = nums.length-1;
        int left = 0, right = n;
        int last = nums[n];

        while( left < n && nums[left] == last ) {
            left++;
        }

        while( left < right ) {
            int mid = ( left + right ) / 2;

            if( nums[mid] > last ) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}