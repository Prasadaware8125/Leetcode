/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Boolean> map = new HashMap<>();

        ListNode l1 = headA;
        while( l1 != null ) {
            map.put(l1, true);
            l1 = l1.next;
        }

        ListNode l2 = headB;
        while( l2 != null ) {
            if( map.containsKey(l2) ) {
                return l2;
            }
            l2 = l2.next;
        }

        return null;
    }
}