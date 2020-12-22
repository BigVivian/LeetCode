package Fight;

public class DeepestLeavesSum_1302_2 {

    public int deepestLeavesSum2(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        int sum = 0;
        while(list.size() != 0){
            sum = 0;
            int size = list.size();
            for(int i = 0; i < size; i++) {
                TreeNode curNode = list.poll();
                sum += curNode.val;

                if(curNode.right != null) list.add(curNode.right);
                if(curNode.left != null) list.add(curNode.left);
            }
        }

        return sum;
    }
}