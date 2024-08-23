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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int i = 0;
        int len = 0;
        
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int rn = len -n;
        if(rn ==0){
            return head.next;
        }
        temp = head;
        while(temp != null){
            i++;
            if(i ==rn){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
}