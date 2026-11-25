import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    private static class PriceSpan {
        final int price;
        final int span;

        PriceSpan(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    private final Deque<PriceSpan> stack;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }
        stack.push(new PriceSpan(price, span));
        return span;
    }
}