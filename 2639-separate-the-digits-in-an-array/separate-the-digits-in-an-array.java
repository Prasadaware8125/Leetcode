class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = nums.length - 1;
        while (len >= 0) {
            int num = nums[len];
            while (num > 0) {
                list.add(num % 10);
                num = num / 10;
            }
            len--;
        }
        int[] res = new int[list.size()];
        int idx = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res[idx++] = list.get(i);
        }

        return res;
    }
}