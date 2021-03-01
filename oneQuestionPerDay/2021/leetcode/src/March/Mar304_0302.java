package March;

/**
 * 304. 二维区域和检索 - 矩阵不可变     难度：medium
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * <p>
 * 示例:
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * <p>
 * 说明:
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 */

//思路：前缀和
public class Mar304_0302 {

    //matrix[i]的前缀和数组
    int[][] sum;

    public Mar304_0302(int[][] matrix) {
        int m = matrix.length;//行
        if (m != 0) {
            int n = matrix[0].length;//列
            //将sums的列数设为 n+1 的目的是为了方便计算每一行的子数组和，不需要对col1 = 0 的情况特殊处理。
            sum = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i][j + 1] = sum[i][j] + matrix[i][j];
                }
            }
        }

    }

    //计算子数组和
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = row1; i <= row2; i++) {
            ans += sum[i][col2 + 1] - sum[i][col1];
        }
        return ans;
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
}
