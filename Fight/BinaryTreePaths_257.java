package Fight;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode - 257
 * Binary Tree Paths
 * <p/>
 * Print path from root to leaf
 */
public class BinaryTreePaths_257 {

    List<String> res = new LinkedList<String>();
    List<Integer> currentPath = new LinkedList<Integer>();

    public List<String> binaryTreePaths(TreeNode root) {

        getPath(root);

        return res;
    }

    private void getPath(TreeNode node) {
        if (node == null) {
            return;
        }

        currentPath.add(node.val);

        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= currentPath.size() - 2; i++) {
                sb.append(currentPath.get(i) + "->");
            }
            sb.append(currentPath.get(currentPath.size() - 1));

            res.add(sb.toString());
        }

        getPath(node.left);
        getPath(node.right);

        currentPath.remove(currentPath.size() - 1);
    }
}
