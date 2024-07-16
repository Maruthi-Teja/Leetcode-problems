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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        StringBuilder s = new StringBuilder();
        StringBuilder d = new StringBuilder();
        findPath(root,startValue,s);
        findPath(root,destValue,d);
        int i =0 , max_i = Math.min(d.length(),s.length());
        while(i<max_i && s.charAt(s.length()-i-1) == d.charAt(d.length()-i-1))
        ++i;
        return "U".repeat(s.length()-i) + d.reverse().toString().substring(i);

    }

    public boolean findPath(TreeNode root,int value,StringBuilder sb){
        if(root.val==value) return true;
        if(root.left!=null && findPath(root.left,value,sb)){
            sb.append("L");
        }else if(root.right!=null && findPath(root.right,value,sb)){
            sb.append("R");
        }
        return sb.length() > 0;

        
    }
}