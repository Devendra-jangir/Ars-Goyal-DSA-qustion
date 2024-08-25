/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>temp = new ArrayList<>();
        printpostorder(root,temp);
        return temp;
    }
    public static void printpostorder(TreeNode root, List<Integer>temp){
        if(root == null){
            return;
        }
        printpostorder(root.left,temp);
        printpostorder(root.right,temp);
        temp.add(root.val);
    }
}