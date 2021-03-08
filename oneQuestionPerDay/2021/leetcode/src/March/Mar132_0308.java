package March;

import java.util.Arrays;

/**
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数 。
 * <p>
 * 示例 1：
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * <p>
 * 示例 2：
 * 输入：s = "a"
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：s = "ab"
 * 输出：1
 */
public class Mar132_0308 {
    //思路：双动态规划，定义dp[i]为[0,..,i]的分割最少次数，最终状态为分割得到最后一个回文串
    //dp[i] = min{dp[j]} + 1 ，其中[j + 1 ,..., i]也是回文串。
    //若[0,...,i]本身就是回文串，则dp[i] = 0
    //第二个动态规划为判断是否为回文串  g[i][j] == true的必要条件为g[i + 1][j - 1] == true && g[i] == g[j]
    public int minCut(String s) {
        int len = s.length();
        //定义判断回文串的动态规划，初始化全为true
        boolean[][] g = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(g[i], true);
        }
        //判断g[i][j]是否为true
        for (int i = len - 1; i > 0; i--) {
            for (int j = i + 1; j < len; j++) {
                g[i][j] = g[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        //定义dp[i]，表示分割最少次数，初始化为MAX_VALUE
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            if(g[0][i]){
                dp[i] = 0;
            }
            for (int j = 0; j < i; j++) {
                //若[j,...,i]为回文串，则递归判断，取最少次数
                if (g[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
