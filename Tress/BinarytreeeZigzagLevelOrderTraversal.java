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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> li=new ArrayList<>();
        levelOrder(root, 0, li);
        return li;
    }
    public void levelOrder(TreeNode root, int level, List<List<Integer>> li) {
        if(root==null) return;
        if(level>=li.size()) li.add(new ArrayList<>());
        if(level%2==0) li.get(level).add(root.val);
        else li.get(level).add(0, root.val);
        
        levelOrder(root.left, level+1, li);
        levelOrder(root.right, level+1, li);
    }
}
