class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);  // sort array
        int peri = 0, maxPeri = 0;
        for( int i = 2 ; i < nums.length ; i++ ) {  // traverse forward
            if( nums[i] < nums[i-1] + nums[i-2]) {  // check for largest side is greater than other 2 or not
                peri = nums[i] + nums[i-1] + nums[i-2];  // if yes then cal perimeter
            }
            maxPeri = Math.max( maxPeri, peri );
        }

        return maxPeri; // return ans i.e largest perimeter if found else 0
    }
}