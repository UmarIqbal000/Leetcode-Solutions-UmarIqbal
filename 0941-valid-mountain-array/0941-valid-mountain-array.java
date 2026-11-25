class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }

        int i = 0;

        // Climb up strictly increasing slope
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Peak cannot be the first or last element (must both ascend and descend)
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Climb down strictly decreasing slope
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // Valid if we reached the very end of the array
        return i == n - 1;
    }
}