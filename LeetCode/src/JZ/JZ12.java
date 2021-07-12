package JZ;

/*
    剑指 Offer 12. 矩阵中的路径

        给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
        如果 word 存在于网格中，返回 true ；否则，返回 false 。
        单词必须按照字母顺序，通过相邻的单元格内的字母构成，
        其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
        同一个单元格内的字母不允许被重复使用。

    解题思路

        exist()
            1. 数组或者字符串为空，返回false
            2. 字符串转成字符数组s
            3. 遍历数组
                1. 判断，若当前字符不是s首字符，跳出本次循环
                2. 若当前字符是s首字符，且dfs()结果为true，返回true
            4. 返回false

        dfs()
            1. 递归结束条件
                1. 数组越界，或者字符不匹配返回false
                2. 当前字符匹配且为字符串末位字符，返回true
            2. 令当前字符为'\0'
            3. 对当前字符的四个方向分别递归处理，res为最终结果
            4. 恢复当前字符，返回res

*/

public class JZ12 {

    public boolean exist(char[][] board, String word) {

        if (board==null || word==null){
            return false;
        }

        char[] s = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!=s[0]){
                    continue;
                }
                if(dfs(board,s,i,j,0)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, char[] s, int i, int j, int k) {

        // dfs递归结束条件
        // 数组越界，或者字符不匹配返回false
        if ( i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=s[k]){
            return false;
        }
        if (k==s.length-1){
            return true;
        }

        // 对当前字符的上下左右四个方向分别递归处理
        board[i][j] = '\0';
        boolean res = dfs(board,s,i-1,j,k+1) || dfs(board,s,i+1,j,k+1)
                || dfs(board,s,i,j-1,k+1) || dfs(board,s,i,j+1,k+1);

        // 恢复现场
        board[i][j] = s[k];
        return res;

    }

}
