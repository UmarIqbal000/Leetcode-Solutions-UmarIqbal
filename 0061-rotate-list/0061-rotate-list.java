/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Compute length 'n' and find the current tail
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // 2. Reduce k to effective rotations
        k %= n;
        if (k == 0) {
            return head;
        }

        // 3. Form a cycle and move (n - k) steps from tail to reach newTail
        tail.next = head;
        int stepsToNewTail = n - k;
        ListNode newTail = tail;
        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        // 4. Break the cycle and return the new head
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}