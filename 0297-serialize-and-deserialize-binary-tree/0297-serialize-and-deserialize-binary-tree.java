

public class Codec {

    public List<String> serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));
        helper(node.left, list);
        helper(node.right, list);
    }

   
    public TreeNode deserialize(List<String> data) {
       
        Collections.reverse(data);
        return helper1(data);
    }

    
    private TreeNode helper1(List<String> data) {
        if (data.isEmpty()) {
            return null;
        }
        
        String s = data.remove(data.size() - 1);
        
        if (s.equals("null")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(s));
        
        node.left = helper1(data);
        node.right = helper1(data);
        
        return node;
    }
}
