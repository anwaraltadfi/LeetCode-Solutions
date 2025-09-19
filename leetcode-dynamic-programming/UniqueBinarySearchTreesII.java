/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        // لو ما في عناصر، رجّع قائمة فاضية (حالة أمان)
        if (n == 0) return new ArrayList<>();
        Map<String, List<TreeNode>> memo = new HashMap<>();
        return build(1, n, memo);
    }

    private List<TreeNode> build(int lo, int hi, Map<String, List<TreeNode>> memo) {
        String key = lo + "#" + hi;
        if (memo.containsKey(key)) {
            return memo.get(key); // استرجاع نتيجة محسوبة سابقًا
        }

        List<TreeNode> res = new ArrayList<>();

        // مجال فارغ ⇒ شجرة واحدة "فارغة" (null) لتسهيل التركيب
        if (lo > hi) {
            res.add(null);
            memo.put(key, res);
            return res;
        }

        // جرّب كل قيمة كجذر
        for (int root = lo; root <= hi; root++) {
            List<TreeNode> leftTrees  = build(lo, root - 1, memo); // كل أشجار اليسار
            List<TreeNode> rightTrees = build(root + 1, hi, memo); // كل أشجار اليمين

            // ركّب كل تركيبة من يسار × يمين
            for (TreeNode L : leftTrees) {
                for (TreeNode R : rightTrees) {
                    TreeNode node = new TreeNode(root);
                    node.left = L;
                    node.right = R;
                    res.add(node);
                }
            }
        }

        memo.put(key, res); // خزّن النتيجة للمجال (lo..hi)
        return res;
    }
}
