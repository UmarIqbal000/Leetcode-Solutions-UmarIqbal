class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Rising slope: peak is after mid
                left = mid + 1;
            } else {
                // Falling slope: peak is at mid or before mid
                right = mid;
            }
        }

        return left;
    }
}