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
        // Crate a dummy node that points to the head
        // This hadles edge cases
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // pointer to traverse 
        ListNode current = dummy;

        while( current.next != null ) {
            if( current.next.val == val ) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        // return dummy.next (the new head of the modified list)
        return dummy.next;
    }
}