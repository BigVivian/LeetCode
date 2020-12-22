package Fight;

public class DeepestLeavesSum_1302 {
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        int d = depth(root);
        traverse(root, 1, d);
        return sum;
    }

    public int depth(TreeNode root) {
        if(root == null) return 0;
        int right = depth(root.right) + 1;
        int left = depth(root.left) + 1;
        return right > left ? right : left;
    }

    public void traverse(TreeNode root, int count, int target) {
        if(count == target) sum += root.val;
        if(root.right != null) traverse(root.right, count + 1, target);
        if(root.left != null) traverse(root.left, count + 1, target);
        return;
    }
}