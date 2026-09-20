class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int currentArea = width * h;
            
            if (currentArea > maxWater) {
                maxWater = currentArea;
            }

            // Move the pointer pointing to the shorter bar inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}