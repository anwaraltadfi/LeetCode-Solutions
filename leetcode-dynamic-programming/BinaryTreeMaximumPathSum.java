class Solution {
    private int globalMax;

    public int maxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;
        dfs(root);
        return globalMax;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // كسب اليسار واليمين (لو سلبي، منعتبره 0 حتى ما يضرّنا)
        int leftGain  = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // مسار يمر عبر هالعقدة (ممكن ينعطف ياخذ الفرعين)
        int pathThroughNode = node.val + leftGain + rightGain;

        // تحديت الجواب العالمي
        globalMax = Math.max(globalMax, pathThroughNode);

        // الكسب للأب (خط واحد فقط)
        return node.val + Math.max(leftGain, rightGain);
    }
}
