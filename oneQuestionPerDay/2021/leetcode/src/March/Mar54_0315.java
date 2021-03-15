package March;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵     难度：medium
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Mar54_0315 {
    //思路：暴力法
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int count = 0, total = m * n;
        int left = 0, right = n - 1, top = 0, botton = m - 1;
        while (count < total) {
            //从左到右遍历最上方一行的元素
            for (int i = left; i <= right && count < total; i++) {
                ans.add(matrix[top][i]);
                count++;
            }
            //top+1避免重复遍历右上角的元素
            top++;
            //从上到下遍历最右侧一列的元素
            for (int i = top; i <= botton && count < total; i++) {
                ans.add(matrix[i][right]);
                count++;
            }
            //right-1避免重复右下角的元素
            right--;
            //从右往左遍历最下方一行的元素
            for (int i = right; i >= left && count < total; i--) {
                ans.add(matrix[botton][i]);
                count++;
            }
            //botton-1避免重复左下角的元素
            botton--;
            //从下往上遍历最左侧一列的元素
            for (int i = botton; i >= top && count < total; i--) {
                ans.add(matrix[i][left]);
                count++;
            }
            //left-1避免重复左上角的元素
            left++;

        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }
}
