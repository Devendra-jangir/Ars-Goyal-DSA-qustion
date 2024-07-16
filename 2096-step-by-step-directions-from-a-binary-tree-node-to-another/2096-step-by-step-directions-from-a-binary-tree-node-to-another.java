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
   
    public TreeNode Lca(TreeNode root, int s , int d){
        if(root==null){
            return null;
        }
        if(root.val == s|| root.val == d){
            return root;
        }
        TreeNode lt = Lca(root.left, s, d);
        TreeNode rt = Lca(root.right, s,d);
        
        if(lt != null && rt != null){
            return root;
        }
        return lt==null ?rt:lt;
    }
    public boolean findPath(TreeNode root, int target, StringBuilder locals){
        if(root==null){
            return false;
        }
        if(root.val == target){
            return true;
        }
        
        locals.append('L');
        if(findPath(root.left, target, locals)){
            return true;
        }
        locals.deleteCharAt(locals.length()-1);
        
        locals.append('R');
        if(findPath(root.right, target, locals)){
            return true;
        }
        locals.deleteCharAt(locals.length()-1);
        return false;
        
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = Lca(root, startValue, destValue);
        
        StringBuilder localleft = new StringBuilder();
        StringBuilder localright = new StringBuilder();
        
        findPath(lca, startValue, localleft);
        findPath(lca, destValue, localright);
        
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<localleft.length(); i++){
            ans.append('U');
        }
        ans.append(localright);
        return ans.toString();
        
    }
     
}
