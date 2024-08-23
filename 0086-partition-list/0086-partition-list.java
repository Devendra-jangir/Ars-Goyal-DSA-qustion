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
    public ListNode partition(ListNode head, int x) {
        
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);
        
        
        ListNode less = lessDummy;
        ListNode greater = greaterDummy;
        
        
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                less.next = current; 
                less = less.next;   
            } else {
                greater.next = current;
                greater = greater.next;
            }
            current = current.next; 
        }
        
        greater.next = null;
        
        less.next = greaterDummy.next;
        
        return lessDummy.next;
    }
}
