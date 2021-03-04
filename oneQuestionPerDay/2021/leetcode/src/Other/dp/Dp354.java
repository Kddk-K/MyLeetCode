package Other.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * 354. 俄罗斯套娃信封问题   难度：hard
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 *
 * 示例 1：
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 示例 2：
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 */
//思路：动态规划，求二维最长递增子序列，[w,h],先按w升序，若w相同则按h降序。
public class Dp354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(int[] arr1, int[] arr2)->{
            return arr1[0] == arr2[0] ? (arr2[1] - arr1[1]) : (arr1[0] - arr2[0]);
        });
        return lengthOfLIS(envelopes);
    }

    private int lengthOfLIS(int[][] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i][1] > nums[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}
