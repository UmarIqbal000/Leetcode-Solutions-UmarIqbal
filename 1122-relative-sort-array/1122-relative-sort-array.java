class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        
        // Count frequencies of each element in arr1
        for (int num : arr1) {
            count[num]++;
        }
        
        int idx = 0;
        
        // Place elements according to arr2's relative ordering
        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[idx++] = num;
                count[num]--;
            }
        }
        
        // Place remaining elements in ascending order
        for (int num = 0; num <= 1000; num++) {
            while (count[num] > 0) {
                arr1[idx++] = num;
                count[num]--;
            }
        }
        
        return arr1;
    }
}