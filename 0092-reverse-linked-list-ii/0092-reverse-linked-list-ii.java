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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: if head is null or left == right, no need to reverse
        if (head == null || left == right) {
            return head;
        }
        
        ListNode ans = new ListNode(0); // Create a dummy node to handle boundary conditions
        ans.next = head;
        ListNode temp = ans; // Temp will point to the node before the left position
        
        // Move temp to the node just before the left-th node
        int i = 1;
        while (i < left) {
            temp = temp.next;
            i++;
        }
        
        // Start reversing from temp.next (which is the node at position left)
        ListNode reverseStart = temp.next; 
        ListNode ntemp = reverseStart; // Pointer to traverse the range for reversal
        
        // Move ntemp to the right-th node
        for (i = left; i < right; i++) {
            ntemp = ntemp.next;
        }
        
        ListNode r = ntemp.next; // The node after the right-th node
        ntemp.next = null; // Cut off the sublist that needs to be reversed
        
        // Reverse the sublist starting at reverseStart
        ListNode node = reverse(reverseStart);
        temp.next = node; // Connect the node before the reversed sublist to the new head
        
        // Now, traverse the reversed part to its end
        while (temp.next != null) {
            temp = temp.next;
        }
        
        // Connect the reversed part's tail to the remaining part of the original list
        temp.next = r;
        
        return ans.next; // Return the new head (skipping the dummy node)
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
