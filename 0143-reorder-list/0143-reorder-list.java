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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the length of the list
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Step 2: Find the middle node to split the list into two halves
        ListNode temp2 = head;
        for (int i = 0; i < (n - 1) / 2; i++) {
            temp2 = temp2.next;
        }

        // Step 3: Reverse the second half of the list starting from temp2.next
        ListNode second = reverse(temp2.next);
        temp2.next = null;  // Split the first half by disconnecting it from the second half

        // Step 4: Merge the two halves - first half (head) and reversed second half
        ListNode first = head;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2_next = second.next;

            first.next = second;  // Add node from second half to first half
            second.next = temp1;  // Link second half node to the next node in the first half

            first = temp1;  // Move to the next node in the first half
            second = temp2_next;  // Move to the next node in the second half
        }
    }

    // Reverse function to reverse the second half of the list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
