
package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    652. 寻找重复的子树

        给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
        两棵树重复是指它们具有相同的结构以及相同的结点值。

    解题思路

        1. 设allTreeMap存放所有子树以及出现次数,treeNodeList存放重复子树根节点
        2. 调用stringTrees()方法,初始参数为root
            1. 方法主要作用:将二叉树序列化成字符串
            2. 递归结束条件root==null
            3. 分别调用方法递归处理左右子树并拼接字符串
            4. 判断此子树之前是否出现过
            5. 出现次数=1,加入结果列表
            6. 存放到allTreeMap,出现次数+1
            7. 返回字符串

*/

public class O_652 {

    //存放所有子树以及出现次数
    HashMap<String,Integer> allTreeMap ;

    //存放重复子树根节点
    List<TreeNode> treeNodeList ;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        allTreeMap = new HashMap<>();
        treeNodeList = new ArrayList<>();
        stringTrees(root);
        return treeNodeList;

    }

    //把二叉树序列化成字符串
    public String stringTrees(TreeNode root){

        //递归结束条件
        if (root==null){
            return "#";
        }

        //分别调用方法递归处理左右子树并拼接字符串
        String subTreeString = stringTrees(root.left) + "," + stringTrees(root.right) + "," + root.val ;

        //判断此子树之前是否出现过
        int num = allTreeMap.getOrDefault(subTreeString,0);

        //出现次数=1,加入结果列表
        if (num==1){
            treeNodeList.add(root);
        }

        //存放到map,出现次数+1
        allTreeMap.put(subTreeString,num+1);

        return subTreeString;

    }

}
