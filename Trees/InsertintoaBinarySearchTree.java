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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode root1=root;
       while(root1!=null){
            if(root1.left==null && root1.val>val) root1.left =new TreeNode(val);
            if(root1.right==null && root1.val<val) root1.right =new TreeNode(val);
              
            if(root1.val>val) root1=root1.left;
            else root1=root1.right;
       }
       return root;
    }
}
