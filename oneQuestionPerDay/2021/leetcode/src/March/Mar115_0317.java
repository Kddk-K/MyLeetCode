package March;

/**
 * 115. 不同的子序列      难度：hard
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * 示例 1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 * 示例 2：
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 */
//思路：动态规划，dp[i][j]表示s[i:]的子序列中t[j:]出现的个数，边界j=n时，t[j:]为空，dp[i][n] = 1
    //  i = m 且j < n时，s[i:]为空，dp[m][j] = 0
    //  i < m 且 j < n时，分两种情况，从t的最后一个字符开始，判断该字符是否和s的最后一个字符匹配，
    //  若匹配，则dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j]
    //  若不匹配，则dp[i][j] = dp[i + 1][j]
    //遍历到dp[0][0]即为最终结果
public class Mar115_0317 {
    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if(m < n) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            dp[i][n] = 1;
        }

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                }else{
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
