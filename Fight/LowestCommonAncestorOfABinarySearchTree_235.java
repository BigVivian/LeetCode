package Fight;

/**
 * LeetCode-235 / Lowest Common Ancestor Of A Binary Search Tree
 */
public class LowestCommonAncestorOfABinarySearchTree_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = p.val, big = q.val;
        if (p.val > q.val) {
            small = q.val;
            big = p.val;
        }

        return getRoot(root, small, big);

    }

    private TreeNode getRoot(TreeNode root, int small, int big) {
        if (root.val == small || root.val == big) {
            return root;
        }

        // go to the right
        if (root.val < small && root.val < big) {
            return getRoot(root.right, small, big);
        }

        // go to the left
        if (root.val > small && root.val > big) {
            return getRoot(root.left, small, big);
        }

        // my root
        if (root.val > small && root.val < big) {
            return root;
        }

        return null;
    }
}
