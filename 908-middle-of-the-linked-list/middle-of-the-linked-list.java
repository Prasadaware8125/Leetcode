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
    public int len(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while( temp != null ) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    public ListNode middleNode(ListNode head) {
        if( head == null || head.next == null ) return head;
        int size = len(head);
        int mid = size/2;
        ListNode temp = head;
        int idx = 1;
        while( idx < mid) {
            temp = temp.next;
            idx++;
        }

        return temp.next;
    }
}