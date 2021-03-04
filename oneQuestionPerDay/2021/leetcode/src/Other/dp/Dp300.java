package Other.dp;

import java.util.Arrays;
import java.util.Map;

/**
 * 300. 最长递增子序列     难度：medium
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */
public class Dp300 {
    //思路：动态规划，dp[i]为前i个元素以第i个结尾的最长递增子序列的长度
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //初始化全设置为1
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                //判断
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}
