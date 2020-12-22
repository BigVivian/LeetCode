package Fight;

public class BstToGst_1038 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root.right != null) bstToGst(root.right);
        root.val = sum + root.val;
        sum = root.val;
        if(root.left != null) bstToGst(root.left);
        return root;
    }
}
