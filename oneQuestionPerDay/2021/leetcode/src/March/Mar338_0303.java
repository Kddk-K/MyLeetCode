package March;

/**
 * 338. 比特位计数       难度：medium
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 */
public class Mar338_0303 {
    //思路：位运算，利用前面算过的数计算当前数的1的个数
    public static int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for(int i = 1; i <= num; i++){
            //i & (i - 1)可以去掉i最右边的一个1（如果有），因此 i & (i - 1）是比 i 小的，
            //而且i & (i - 1)的1的个数已经在前面算过了，所以i的1的个数就是 i & (i - 1)的1的个数加上1
            ans[i] = ans[i & (i - 1)] + 1;
            System.out.println(ans[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        countBits(5);
    }
}
