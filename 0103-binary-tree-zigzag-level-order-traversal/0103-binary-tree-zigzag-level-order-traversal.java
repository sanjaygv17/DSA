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
        List<List<Integer>> result=new ArrayList<>();

        if(root == null){
            return result;
        }

        boolean flag=false;
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offerFirst(root);

        while(!queue.isEmpty()){
            int level=queue.size();
            List<Integer> currentList=new ArrayList<>();
            for(int i=0;i<level;i++){
                if(flag){
                    TreeNode currentNode=queue.pollLast();
                    currentList.add(currentNode.val);
                    if(currentNode.right != null){
                        queue.addFirst(currentNode.right);
                    }
                    if(currentNode.left != null){
                        queue.addFirst(currentNode.left);
                    }
                    
                    
                }else{
                TreeNode currentNode=queue.pollFirst();
                currentList.add(currentNode.val);
                if(currentNode.left != null){
                    queue.addLast(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.addLast(currentNode.right);
                    
                }
                
                }
            }
            flag = !flag;
            
            result.add(currentList);
        }
        return result;
    }
}