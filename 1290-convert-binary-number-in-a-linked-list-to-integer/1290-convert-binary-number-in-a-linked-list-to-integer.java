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
public class Solution {
    public int getDecimalValue(ListNode head) {
        head = reverse(head);
        
        ListNode temp = head;
        int ans = 0;
        int p = 1;
        
        while (temp != null) {
            ans += p * temp.val;
            p *= 2;
            temp = temp.next;
        }
        
        return ans;
    }
    
    // Corrected reverse method
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        return prev; 
    }
}
