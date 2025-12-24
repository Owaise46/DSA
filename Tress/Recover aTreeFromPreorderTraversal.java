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
    int idx = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return dfs(traversal, 0);
    }
    TreeNode dfs(String s, int depth) {
        int dashes=0;
        while(idx + dashes < s.length() && s.charAt(idx+dashes)=='-'){
            dashes++;
        }
        if(dashes != depth) return null;
        idx += dashes;
        int value=0;
        while(idx < s.length() && s.charAt(idx)!='-'){
            value=value*10+(s.charAt(idx++)-'0');
        }
        TreeNode node=new TreeNode(value);
        node.left=dfs(s, depth+1);
        node.right=dfs(s, depth+1);
        return node;
    }
}
