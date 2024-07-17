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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int d : to_delete) {
            toDeleteSet.add(d);
        }
        
        root = delete(root, toDeleteSet, result);
        
        // If the root is not deleted, add it to the result list
        if (root != null) {
            result.add(root);
        }
        
        return result;
    }
    
    public TreeNode delete(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> result) {
        if (node == null) {
            return null;
        }
        
        node.left = delete(node.left, toDeleteSet, result);
        node.right = delete(node.right, toDeleteSet, result);
        if (toDeleteSet.contains(node.val)) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }
            return null;
        }
        return node;
    }
}
