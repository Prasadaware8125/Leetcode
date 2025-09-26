class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1, n = nums.length;
        while( j < n ) {
            if( nums[i] != nums[j] ) {  // if the numbers are not equal then exchange the element of j with ele of i+1
                i++;
                nums[i] = nums[j];
            }
            j++;    
            // else continue
        }

        return i+1; // returns the number of swap or the number of diff eles
    }
}