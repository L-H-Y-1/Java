package Tree;

/*
    230. 二叉搜索树中第K小的元素

        给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

    解题思路

        1. 设置resVal记录结果,index记录次序
        2. 调用traverse()方法中序遍历二叉树
            1. 递归结束条件root==null
            2. BST是中序遍历,故先处理顺序为左子树,当前节点,右子树
            3. 次序++,若index==k,返回结果

*/
public class P_230 {

    public int kthSmallest(TreeNode root, int k) {

        traverse(root,k);
        return resVal;

    }

    //设置resVal记录结果,index记录次序
    int resVal = 0;
    int index = 0;

    public void traverse(TreeNode root, int k){

        //递归结束条件
        if (root==null){
            return;
        }

        //BST是中序遍历,故先处理顺序为左子树,当前节点,右子树
        traverse(root.left,k);
        index++;
        if (index==k){
            resVal = root.val;
            return;
        }
        traverse(root.right,k);

    }

}
