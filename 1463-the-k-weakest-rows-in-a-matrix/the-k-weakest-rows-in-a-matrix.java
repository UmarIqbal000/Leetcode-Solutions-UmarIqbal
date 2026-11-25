import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // Max-heap: largest soldier count at top; on tie, largest row index at top
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        for (int i = 0; i < mat.length; i++) {
            int soldiers = countSoldiers(mat[i]);
            maxHeap.offer(new int[]{soldiers, i});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int idx = k - 1; idx >= 0; idx--) {
            result[idx] = maxHeap.poll()[1];
        }
        return result;
    }

    private int countSoldiers(int[] row) {
        int left = 0;
        int right = row.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}