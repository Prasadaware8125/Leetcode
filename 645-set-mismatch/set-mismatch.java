class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int ans[] = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for( int num : nums) {
            if( map.containsKey(num) ) {
                ans[0] = nums[idx];
                nums[idx] = 0;
                break;
            }
            map.put(num,1);
            idx++;
        }
        int oSum = 0, aSum = 0;
        for( int i = 0 ; i < n ; i++ ) {
            oSum += i+1;
            aSum += nums[i];
        }

        ans[1] = oSum - aSum;
        return ans;
    }
}