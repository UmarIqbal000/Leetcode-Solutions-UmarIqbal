import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int curr : asteroids) {
            boolean alive = true;

            while (alive && curr < 0 && !stack.isEmpty() && stack.peekLast() > 0) {
                int top = stack.peekLast();
                int currSize = -curr; // since curr < 0, -curr equals Math.abs(curr)

                if (top < currSize) {
                    stack.pollLast(); // top explodes; curr continues left
                } else if (top == currSize) {
                    stack.pollLast(); // both explode
                    alive = false;
                } else {
                    alive = false; // curr explodes
                }
            }

            if (alive) {
                stack.addLast(curr);
            }
        }

        int[] result = new int[stack.size()];
        int i = 0;
        for (int val : stack) {
            result[i++] = val;
        }
        return result;
    }
}