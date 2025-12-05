class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for( int num : nums ) {
            sum += num;
        }

        if( sum % 2 != 0 ) {
            return 0;
        }

        int currSum = 0, count = 0, nextArr = 0;
        for( int i = 0 ; i < nums.length ; i++ ) {
            currSum += nums[i];
            nextArr = sum - currSum;
            if( (currSum + nextArr)  % 2 == 0 ) {
                count++;
            }
        }
        return count-1;
    }
}