package Fight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_107 {

    List<List<Integer>> ret = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        levelTraverse(root, 0);

        // reverse the result set
        Collections.reverse(ret);

        return ret;
    }

    private void levelTraverse(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        // add a new List when traverse to next level
        if (level == ret.size()) {
            List<Integer> emptyList = new ArrayList<Integer>();
            ret.add(emptyList);
        }

        ret.get(level).add(root.val);
        levelTraverse(root.left, level + 1);
        levelTraverse(root.right, level + 1);

    }
}
