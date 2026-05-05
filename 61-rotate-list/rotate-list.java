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
        // Base Case
        if( head == null || head.next == null || k == 0 ) return head;

        // Finding Length of ll
        ListNode temp = head;
        int len = 1;
        while( temp.next != null ) {
            temp = temp.next;
            len++;
        }

        // Make Circular
        temp.next = head;

        // Find new head
        k = k % len;
        int steps = len - k;

        ListNode newTail = head;
        for( int i = 1 ; i < steps ; i++ ) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // break the cycle
        newTail.next = null;

        return newHead;
    }
}