class Solution {
    public void merge(int[] nums, int si, int mid, int ei) {
        int[] temp = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;


        while( i <= mid && j <= ei ) {
            if( nums[i] < nums[j] ) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        while( i <= mid ) {
            temp[k++] = nums[i++];
        }

        while( j <= ei ) {
            temp[k++] = nums[j++];
        }

        for( k = 0, i = si ; k < temp.length ; k++, i++ ) {
            nums[i] = temp[k];
        }

    }
    public void mergeSort(int[] nums, int i, int j) {
        if( i >= j ) {
            return;
        }
        int mid = i+(j-i) / 2;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid+1, j);

        merge(nums, i, mid, j);
    }
    public int[] sortedSquares(int[] nums) {
        for( int i = 0 ; i < nums.length ; i++ ) {
            nums[i] = nums[i]*nums[i];
        }
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}