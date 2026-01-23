class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Step 1: Handle the head of the list
        // While the list is not empty AND the head needs to be removed,
        // move the head pointer forward.
        while (head != null && head.val == val) {
            head = head.next;
        }

        // Check if the list became empty after removing heads
        if (head == null) {
            return null;
        }

        // Step 2: Handle the rest of the list
        // We now know head.val != val, so we can start checking from head.
        ListNode current = head;
        
        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node
                current.next = current.next.next;
            } else {
                // Move to next node only if we didn't delete
                current = current.next;
            }
        }
        
        return head;
    }
}