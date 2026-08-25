class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        int n = a.length;

        for (int start = 0; start < n; start += 2 * k) {
            int left = start;
            int right = Math.min(start + k - 1, n - 1);

            while (left < right) {
                char temp = a[left];
                a[left++] = a[right];
                a[right--] = temp;
            }
        }
        return new String(a);
    }
}