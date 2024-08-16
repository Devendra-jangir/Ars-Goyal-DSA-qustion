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
    public ListNode middleNode(ListNode head) {
        // Step 1: Count the total number of nodes in the linked list
        ListNode temp = head;
        int n = 0;
        
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        
        temp = head;
        int middle = n / 2;
        
        for (int i = 0; i < middle; i++) {
            temp = temp.next;
        }
        
        return temp;
    }
}
