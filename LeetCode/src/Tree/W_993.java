package Tree;

/*
    993. 二叉树的堂兄弟节点

        在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
        如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
        我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
        只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。

     解题思路

        1. 思路:
            1. 递归遍历二叉树找到x,y
            2. 在寻找过程中分别记录深度,双亲,以及是否找到
            3. 若找到x,y,深度相等且双亲不同,返回true

        2. 设置成员变量
            1. x的数值,深度,双亲和是否找到
            2. y的数值,深度,双亲和是否找到

        3. isCousins()方法
            1. DFS深度优先遍历,记录深度,双亲,是否找到
            2. 若找到x,y,深度相等且双亲不同,返回true

        4. dfs()方法
            1. 递归结束条件:节点为空
            2. 若找到x,记录深度,双亲,标记已找到
            3. 若找到y,记录深度,双亲,标记已找到
            4. 若x,y都找到,结束递归
            5. 递归遍历当前节点左子树,深度+1,双亲为当前节点
            6. 若x,y都找到,结束递归
            7. 递归遍历当前节点右子树,深度+1,双亲为当前节点

*/

public class W_993 {

    // x的数值，深度，双亲和是否找到
    int x, xDepth=0;
    boolean xFound = false;
    TreeNode xParent = null;

    // y的数值，深度，双亲和是否找到
    int y, yDepth=0;
    boolean yFound = false;
    TreeNode yParent = null;

    public boolean isCousins(TreeNode root, int x, int y) {

        // 令x，y为成员变量，可用于其他方法
        this.x = x;
        this.y = y;

        // DFS深度优先遍历，记录深度，双亲，是否找到
        dfs(root,0,null);

        // 若找到x，y，深度相等且双亲不同，返回true
        return xFound && yFound && (xDepth==yDepth) && (xParent!=yParent);

    }

    //DFS
    public void dfs(TreeNode node, int depth, TreeNode parent) {

        // 递归结束条件
        if (node==null){
            return;
        }

        // 若找到x，记录深度，双亲，标记已找到
        if(node.val==this.x){
            this.xDepth = depth;
            this.xParent = parent;
            this.xFound = true;
        }
        // 若找到y，记录深度，双亲，标记已找到
        if (node.val==this.y){
            this.yDepth = depth;
            this.yParent = parent;
            this.yFound = true;
        }

        // 若x，y都找到，结束递归
        if (xFound&&yFound){
            return;
        }

        // 递归遍历当前节点左子树，深度+1，双亲为当前节点
        dfs(node.left,depth+1,node);

        // 若x，y都找到，结束递归
        if (xFound&&yFound){
            return;
        }

        // 递归遍历当前节点右子树，深度+1，双亲为当前节点
        dfs(node.right,depth+1,node);

    }



}
