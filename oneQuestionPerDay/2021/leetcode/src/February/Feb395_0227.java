package February;

import java.util.Arrays;

/**
 * 395. 至少有 K 个重复字符的最长子串    难度：medium
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *
 * 示例 1：
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 * 示例 2：
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 */
//滑动窗口
public class Feb395_0227 {
    public static int longestSubstring(String s, int k) {
        int ans = 0;
        int len = s.length();
        //i为字符种类数量，26个字母，枚举
        for(int i = 1; i <= 26; i++){
            //滑动窗口左右边界
            int left = 0, right = 0;
            //窗口内部每个字符出现次数
            int[] cnt = new int[26];
            //窗口内字符种类数目
            int tol = 0;
            int less = 0;
            while(right < len){
                cnt[s.charAt(right) - 'a']++;
                if(cnt[s.charAt(right) - 'a'] == 1){
                    tol++;
                    less++;
                }
                if(cnt[s.charAt(right) - 'a'] == k){
                    less--;
                }

                while(tol > i){
                    cnt[s.charAt(left) - 'a']--;
                    if(cnt[s.charAt(left) - 'a'] == k - 1){
                        less++;
                    }
                    if(cnt[s.charAt(left) - 'a'] == 0){
                        tol--;
                        less--;
                    }
                    left++;
                }
                if(less == 0){
                    ans = Math.max(ans, right - left + 1);
                }
                right++;
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        longestSubstring("ababbc",2);
    }
}
