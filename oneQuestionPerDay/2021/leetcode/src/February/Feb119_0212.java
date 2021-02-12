package February;

import java.util.Arrays;
import java.util.List;

/**
 * 119. 杨辉三角 II     难度：easy
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 */

//思路：动态规划，利用滚动数组的思想，
public class Feb119_0212 {
    public static List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        //初始化
        Arrays.fill(dp,1);
        //dp[j](当前行第j个)=dp[j](上一行第j个)+dp[j−1](上一行第j−1个);
        //使用一维数组滚动计算当前行第j个数dp[j]时，dp[j-1]应该还代表的是上一行的第j-1个的数据，
        //即dp[j-1]应该后于dp[j]被计算，所以对于列j的遍历顺序应该是从后往前

        for(int i = 2; i < dp.length; i++){
            for(int j = i- 1; j > 0; --j){
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        List<Integer> res = Arrays.asList(dp);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        getRow(4);
    }
}
