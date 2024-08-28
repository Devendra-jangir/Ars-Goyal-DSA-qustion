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
        ListNode ans = new ListNode(0); 
        ListNode a = ans;
        ListNode temp = head;  
        
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                temp = temp.next; 
            } else {
                
                a.next = temp;
                a = a.next;  
                temp = temp.next;  
            }
        }
        a.next = temp;  
        return ans.next;  
    }
}
