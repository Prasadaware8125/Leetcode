class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        double ans = 0.0;
        while( i < nums1.length && j < nums2.length ) {
            if( nums1[i] < nums2[j] ) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        while( i < nums1.length ) {
            list.add(nums1[i++]);
        }
        while( j < nums2.length ) {
            list.add(nums2[j++]);
        }

        int mid = list.size()/2;
        if( list.size() % 2 == 0 ) {
            ans =  (double)(list.get(mid) + list.get(mid-1)) / 2;
        } else {
            ans =  list.get(mid);
        }
        return ans;
    }
}