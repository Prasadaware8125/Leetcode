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
        // Handling if head = val
        while( head != null && head.val == val ) {
            head = head.next;
        }

        // if head is null
        if( head == null ) return null;
        ListNode temp = head;

        // handle rest of list
        while( temp.next != null ) {
            if( temp.next.val == val ) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}