class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] in, int il, int ir,
                   int[] post, int pl, int pr) {

        if (il > ir || pl > pr)
            return null;

        TreeNode root = new TreeNode(post[pr]);

        int i = il;
        while (in[i] != post[pr])
            i++;

        int leftSize = i - il;

        root.left = build(in, il, i - 1,
                          post, pl, pl + leftSize - 1);

        root.right = build(in, i + 1, ir,
                           post, pl + leftSize, pr - 1);

        return root;
    }
}
