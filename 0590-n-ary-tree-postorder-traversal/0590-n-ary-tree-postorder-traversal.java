/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer>temp = new ArrayList<>();
        return printpostorder(root, temp);
    }
    public List<Integer>printpostorder(Node root, List<Integer>temp){
        if(root == null){
            return temp;
        }
        for (int i = 0; i<root.children.size(); i++){
            temp = printpostorder(root.children.get(i), temp);
        }
        temp.add(root.val);
        return temp;
    }
}