/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
//         if (head == null) return null;
        
//         HashMap<Node, Node> map = new HashMap<>();
        
//         // Step 1: Create a copy of each node and store in the map
//         Node temp = head;
//         while (temp != null) {
//             map.put(temp, new Node(temp.val));
//             temp = temp.next;
//         }
        
//         // Step 2: Assign next and random pointers for the copied nodes
//         temp = head;
//         while (temp != null) {
//             Node copy = map.get(temp);
//             copy.next = map.get(temp.next);
//             copy.random = map.get(temp.random);
//             temp = temp.next;
//         }
        
//         return map.get(head);
        
//         Second solution
        
         if (head == null) return null;
        
        Node temp = head;
        
        // Step 1: Interleave the original and copied nodes
        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        
        // Step 2: Assign random pointers for the copied nodes
        temp = head;
        while (temp != null) {
            temp.next.random = (temp.random != null) ? temp.random.next : null;
            temp = temp.next.next;
        }
        
        // Step 3: Separate the original and copied lists
        Node ans = new Node(-1);
        Node d = ans;
        temp = head;
        
        while (temp != null) {
            d.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            d = d.next;
        }
        
        return ans.next;
    }
}
