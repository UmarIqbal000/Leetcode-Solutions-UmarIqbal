class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        // Use StringBuilder as a stack for O(1) push/pop from the back
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            char current = num.charAt(i);

            // Pop larger previous digits while we still have removals left
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > current) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(current);
        }

        // If k > 0 still remains (e.g., monotonically non-decreasing digits), remove from the end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Strip leading zeros
        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') {
            idx++;
        }

        String result = stack.substring(idx);
        return result.isEmpty() ? "0" : result;
    }
}