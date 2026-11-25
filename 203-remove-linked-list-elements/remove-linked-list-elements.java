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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next; // Bypass the matching node
            } else {
                curr = curr.next;           // Only advance if no node was removed
            }
        }
        
        return dummy.next;
    }
}