package February;

/**
 * 867. 转置矩阵    难度：easy
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 */
public class Feb867_0225 {
    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] ans = new int[col][row];//新矩阵为col行row列
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                ans[i][j] = matrix[j][i];
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
