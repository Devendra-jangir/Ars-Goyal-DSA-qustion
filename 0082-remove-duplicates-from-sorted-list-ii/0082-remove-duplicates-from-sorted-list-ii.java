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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(0);  // Dummy node
        ListNode a = ans;
        ListNode temp = head;  // Use ListNode instead of Node
        
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                // Skip all nodes with the same value
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                temp = temp.next;  // Move to the next distinct value
            } else {
                // Attach the current node to the result list
                a.next = temp;
                a = a.next;  // Move `a` forward
                temp = temp.next;  // Move temp to the next node
            }
        }
        a.next = temp;  // Attach the last node if necessary
        return ans.next;  // Skip the dummy node and return the result
    }
}
