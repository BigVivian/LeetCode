package Fight;

public class FindLargestValueInEachTreeRow_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> tree = new LinkedList<>();
        if(root != null) tree.add(root);

        while(tree.size() != 0) {
            int max = Integer.MIN_VALUE;
            for(int i = tree.size(); i >= 1; i--) {
                TreeNode node = tree.poll();
                if(node.val >= max) max = node.val;
                if(node.right != null) tree.add(node.right);
                if(node.left != null) tree.add(node.left);
            }
            list.add(max);
        }

        return list;
    }
}