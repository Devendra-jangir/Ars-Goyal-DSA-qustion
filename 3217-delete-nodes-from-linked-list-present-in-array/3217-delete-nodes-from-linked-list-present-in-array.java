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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer>s = new HashSet<>();
        
        for(int i =0; i<nums.length; i++){
            s.add(nums[i]);
        }
        
        ListNode newl = new ListNode(0);
        ListNode ntemp = newl;
        
        ListNode temp = head;
        
        while(temp != null){
            if(!s.contains(temp.val)){
                ntemp.next = temp;
                ntemp = ntemp.next;
            }
            temp = temp.next;
        }
        
        ntemp.next = null;
        return newl.next;
    }
}