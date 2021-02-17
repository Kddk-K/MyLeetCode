package February;

/**
 * 566. 重塑矩阵
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 *
 * 示例 2:
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 */
public class Feb566_0217 {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] ans = new int[r][c];
        int m = nums.length;//行
        int n = nums[0].length;//列
        if(m * n != r * c){
            return nums;
        }
        int row = 0, col = 0;//新数组的行和列
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(col == c){
                    row++;//到下一行
                    col = 0;
                }
                ans[row][col] = nums[i][j];//第一个数nums[0][0]一定能赋值成功
                col++;//赋值下一个，直到到了边界c
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        matrixReshape(new int[][]{{1,2,3},{3,4,5}},3,2);
    }
}
