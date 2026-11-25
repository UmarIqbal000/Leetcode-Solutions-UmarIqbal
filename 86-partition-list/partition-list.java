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
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode beforeCurr = beforeHead;

        ListNode afterHead = new ListNode(0);
        ListNode afterCurr = afterHead;

        while (head != null) {
            if (head.val < x) {
                beforeCurr.next = head;
                beforeCurr = beforeCurr.next;
            } else {
                afterCurr.next = head;
                afterCurr = afterCurr.next;
            }
            head = head.next;
        }

        // Prevent a potential cycle from lingering pointers in the original list
        afterCurr.next = null;

        // Connect the "less than x" list to the "greater than or equal to x" list
        beforeCurr.next = afterHead.next;

        return beforeHead.next;
    }
}