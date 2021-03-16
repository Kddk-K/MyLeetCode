package March;

/**
 * 59. 螺旋矩阵 II      难度：medium
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= n <= 20
 */
public class Mar59_0316 {
    //思路：和昨天的螺旋矩阵Ⅰ类似，模拟过程
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        //元素从1开始
        int count = 1, total = n * n;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while(count <= total){
            for(int i = left; i <= right && count <= total; i++){
                ans[top][i] = count++;
            }
            top++;
            for(int i = top; i <= bottom && count <= total; i++){
                ans[i][right] = count++;
            }
            right--;
            for(int i = right; i >= left && count <= total; i--){
                ans[bottom][i] = count++;
            }
            bottom--;
            for(int i = bottom; i >= top && count <= total; i--){
                ans[i][left] = count++;
            }
            left++;
        }

        for (int[] an : ans) {
            System.out.println(an);
        }
        return ans;
    }

    public static void main(String[] args) {
        generateMatrix(4);
    }
}
