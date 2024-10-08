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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode prev = ans;
        ListNode l1 = list1;
        ListNode l2 = list2;
        
        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                ListNode node = new ListNode(l1.val);
                prev.next = node;
                prev = prev.next;
                l1 = l1.next;
            }
            else{
                ListNode node = new ListNode(l2.val);
                prev.next = node;
                prev = prev.next;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            prev.next = l1;
                prev = prev.next;
                l1 = l1.next;
        }
        while(l2 != null){
            prev.next = l2;
                prev = prev.next;
                l2 = l2.next;
        }
        return ans.next;
    }
}