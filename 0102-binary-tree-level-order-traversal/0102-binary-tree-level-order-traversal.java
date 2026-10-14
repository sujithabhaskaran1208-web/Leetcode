class Solution {
    public java.util.List<java.util.List<Integer>> levelOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> ans = new java.util.ArrayList<>();

        if (root == null) {
            return ans;
        }

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            java.util.List<Integer> list = new java.util.ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            ans.add(list);
        }

        return ans;
    }
}