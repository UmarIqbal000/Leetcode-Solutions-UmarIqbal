class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Peak lies to the right of mid
                left = mid + 1;
            } else {
                // Peak is at mid or to the left of mid
                right = mid;
            }
        }

        return left;
    }
}