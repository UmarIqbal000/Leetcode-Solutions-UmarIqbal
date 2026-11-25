import java.util.ArrayDeque;
import java.util.Deque;

class RecentCounter {
    private final Deque<Integer> requests;

    public RecentCounter() {
        requests = new ArrayDeque<>();
    }

    public int ping(int t) {
        requests.addLast(t);
        int lowerBound = t - 3000;

        while (!requests.isEmpty() && requests.peekFirst() < lowerBound) {
            requests.pollFirst();
        }

        return requests.size();
    }
}