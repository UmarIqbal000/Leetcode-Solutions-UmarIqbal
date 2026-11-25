class Solution {
    public String makeGood(String s) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int len = stack.length();

            if (len > 0 && Math.abs(stack.charAt(len - 1) - curr) == 32) {
                stack.deleteCharAt(len - 1);
            } else {
                stack.append(curr);
            }
        }

        return stack.toString();
    }
}