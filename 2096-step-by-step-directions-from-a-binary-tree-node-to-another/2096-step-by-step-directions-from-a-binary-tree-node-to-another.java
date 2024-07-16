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
    String ans = "";
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        
        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDest);
        
        int i = 0;
        while (i < pathToStart.length() && i < pathToDest.length() && pathToStart.charAt(i) == pathToDest.charAt(i)) {
            i++;
        }
        StringBuilder result = new StringBuilder();
        for (int j = i; j < pathToStart.length(); j++) {
            result.append('U');
        }
        result.append(pathToDest.substring(i));
        
        return result.toString();
    }
    
    public boolean findPath(TreeNode node, int value, StringBuilder path) {
        if (node == null) {
            return false;
        }
        if (node.val == value) {
            return true;
        }
        
        path.append('L');
        if (findPath(node.left, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        path.append('R');
        if (findPath(node.right, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
}
