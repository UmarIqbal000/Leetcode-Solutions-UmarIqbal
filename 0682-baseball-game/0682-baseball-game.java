class Solution {
    public int calPoints(String[] operations) {
        int[] stack = new int[operations.length];
        int top = -1;

        for (String op : operations) {
            if (op.equals("+")) {
                int sum = stack[top] + stack[top - 1];
                stack[++top] = sum;
            } else if (op.equals("D")) {
                stack[top + 1] = 2 * stack[top];
                top++;
            } else if (op.equals("C")) {
                top--;
            } else {
                stack[++top] = Integer.parseInt(op);
            }
        }

        int total = 0;
        for (int i = 0; i <= top; i++) {
            total += stack[i];
        }
        return total;
    }
}