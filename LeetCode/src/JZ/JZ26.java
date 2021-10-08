package JZ;

/*
    剑指 Offer 26. 树的子结构

        输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
        B是A的子结构， 即 A中有出现和B相同的结构和节点值。

    解题思路

        #### isSubStructure()
            1. 若A为空或B为空，返回false
            2. 调用isSub()方法判断B与A结构是否相同（根节点值相同，子树结构与值都相同）
            3. 若不同，调用isSubStructure()判断B与A的左右子树结构是否相同
            4. 以上三次调用，其一为真即返回true

        #### isSub()
            1. 若B遍历结束，则A包含B
            2. 若A遍历结束，或两节点值不相等，则A不包含B
            3. 继续遍历左右子树,要求左右子树均返回true

*/

public class JZ26 {

    public static boolean isSubStructure(TreeNode A, TreeNode B) {

        if (B==null || A==null){
            return false;
        }

        // dfs遍历A，找到值与B根节点相同的节点
        // return dfs(A,B);

        // 优化
        return isSub(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);

    }

    public static boolean isSub(TreeNode root1, TreeNode root2){

        // 若B遍历结束，则A包含B
        if (root2==null){
            return true;
        }

        // 若A遍历结束，或两节点值不相等，则A不包含B
        if (root1==null || root1.val!=root2.val){
            return false;
        }

        return isSub(root1.left,root2.left) && isSub(root1.right,root2.right);

    }

    public static boolean dfs(TreeNode root1, TreeNode root2){

        // 若A树遍历完毕也没找到，直接返回false
        if (root1==null){
            return false;
        }

        // 如果A中找到节点与B根节点值相同,判断其子树是否包含B
        if (root1.val == root2.val && contain(root1,root2) ){
            return true;
        }

        // 继续遍历左右子树
        return dfs(root1.left,root2) || dfs(root1.right,root2);

    }

    public static boolean contain(TreeNode root1, TreeNode root2){

        // 若B遍历结束，则A包含B
        if (root2==null){
            return true;
        }

        // 若A遍历结束，或两节点值不相等，则A不包含B
        if (root1==null || root1.val!=root2.val){
            return false;
        }

        // 继续遍历左右子树
        return contain(root1.left,root2.left) && contain(root1.right,root2.right);

    }

}
