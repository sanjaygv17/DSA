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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx=findNode(root,x);
        TreeNode yy=findNode(root,y);

        return(
            level(root,x,0) == level(root,y,0) && !isSiblings(root,xx,yy)
        );

    }

    public TreeNode findNode(TreeNode node,int a){
        if(node == null){
            return null;
        }

        if(node.val==a){
            return node;
        }

        TreeNode n=findNode(node.left,a);
        if(n != null){
            return n;
        }
        return findNode(node.right,a);
    }

    public boolean isSiblings(TreeNode node,TreeNode x,TreeNode y){
        if(node == null){
            return false;
        }
        return(
            (node.left == x && node.right == y) ||  (node.left == y && node.right == x) ||
            isSiblings(node.left,x,y) || isSiblings(node.right,x,y)
        );

    }

    public int level(TreeNode node,int a,int lev){
        if(node==null){
            return 0;
        }

        if(node.val == a){
            return lev;
        }

        int l=level(node.left,a,lev+1);
        if( l != 0){
            return l;
        }
        return level(node.right,a,lev+1);
    }
}