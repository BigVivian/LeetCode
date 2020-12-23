package Fight;

public class FindBottomLeftTreeValue_513 {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        while(list.size() != 0){
            root = list.poll();
            if(root.right != null) list.add(root.right);
            if(root.left != null) list.add(root.left);
        }

        return root.val;
    }
}