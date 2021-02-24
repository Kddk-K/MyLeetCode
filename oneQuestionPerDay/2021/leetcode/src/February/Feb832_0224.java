package February;

/**
 * 832. 翻转图像    难度：easy
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1：
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 示例 2：
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 */
public class Feb832_0224 {
    public static int[][] flipAndInvertImage(int[][] A) {
        for(int[] num : A){//每次遍历到一个数组
            int len = num.length;
            int left = 0;
            int right = len - 1;
            while(left <= right){//双指针相向移动
                int temp = num[left] ^ 1;//temp起到交换作用，异或1可以01互换
                num[left] = num[right] ^ 1;
                num[right] = temp;
                left++;
                right--;
            }
        }
        for (int[] ints : A) {
            System.out.println(ints.toString());
        }

        return A;
    }

    public static void main(String[] args) {
        flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
    }
}
