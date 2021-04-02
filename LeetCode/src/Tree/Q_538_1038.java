package Tree;

/*
    538. 1038. 把二叉搜索树转换为累加树

        给出二叉搜索树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
        使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
        提醒一下，二叉搜索树满足下列约束条件：
        节点的左子树仅包含键 小于 节点键的节点。
        节点的右子树仅包含键 大于 节点键的节点。
        左右子树也必须是二叉搜索树。

    解题思路

        1. 记录累加结果sum
        2. convert()方法
            1. 递归结束条件root==null
            2. 中序遍历,但是求大于或等于val的值之和,所以先走右边
            3. 递归调用convert()方法处理右子树
            4. sum累加val并赋给root
            5. 递归调用convert()方法处理左子树

*/

public class Q_538_1038 {

    public TreeNode convertBST(TreeNode root) {

        convert(root);
        return root;

    }

    //记录结果
    int sum = 0;

    public void convert(TreeNode root) {

        //递归结束条件
        if (root==null){
            return;
        }

        //中序遍历,但是先走右边
        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);

    }

}
