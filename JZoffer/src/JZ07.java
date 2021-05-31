
/*
    重建二叉树
        输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
        假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
        例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
        则重建二叉树并返回。
*/



public class JZ07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

       /*思路
       * 根节点是前序遍历第一个数值
       * 找出中序遍历的根节点,将中序遍历分为左右子树,前序同
       * 递归处理左右子树的前序和中序
       * */

       // 递归结束条件
       if (preStart>preEnd || inStart>inEnd){
           return null;
       }

       // 新建根节点，值为前序第一位
       int rootVal = preorder[preStart];
       TreeNode root = new TreeNode(rootVal);

       // 找出中序遍历的根节点
        int inRootIndex = 0;
        for (int i = 0; i <= inEnd ; i++) {
            if (inorder[i]==rootVal){
                inRootIndex = i;
                break;
            }
        }

        // 计算左子树个数
        int leftNum = inRootIndex-inStart;

        // 中序为[inStart,inRootIndex-1],root,[inRootIndex+1,inEnd]
        // 前序为root,[preStart+1,preStart+leftNum],[preStart+leftNum+1,preEnd]
        // 递归处理左右子树
        root.left = build(preorder,preStart+1,preStart+leftNum,inorder,inStart,inRootIndex-1);
        root.right = build(preorder,preStart+leftNum+1,preEnd,inorder,inRootIndex+1,inEnd);

        return root;

    }

}
class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
}
