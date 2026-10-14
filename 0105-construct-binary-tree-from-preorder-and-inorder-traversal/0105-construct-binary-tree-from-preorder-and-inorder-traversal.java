class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] pre, int pl, int pr,
                   int[] in, int il, int ir) {

        if (pl > pr || il > ir)
            return null;

        // First element of preorder is root
        TreeNode root = new TreeNode(pre[pl]);

        // Find root in inorder
        int i = il;
        while (in[i] != pre[pl])
            i++;

        int leftSize = i - il;

        // Build left subtree
        root.left = build(pre, pl + 1, pl + leftSize,
                          in, il, i - 1);

        // Build right subtree
        root.right = build(pre, pl + leftSize + 1, pr,
                           in, i + 1, ir);

        return root;
    }
}