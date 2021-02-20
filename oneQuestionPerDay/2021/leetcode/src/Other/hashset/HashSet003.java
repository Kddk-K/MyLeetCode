package Other.hashset;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串    难度：medium
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 */

//思路：双指针+Hash，双指针实现滑动窗口，遍历数组，利用hash存元素及其个数，遇到重复元素就移动左指针
public class HashSet003 {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();//泛型一个表示是哪个字符，一个表示该字符出现次数
        for(int left = 0, right = 0; right < s.length(); right++){//[left,right]区间，相当于一个窗口
            char j = s.charAt(right);//定义一个j表示right指针位置的元素
            map.put(j, map.getOrDefault(j, 0) + 1);
            while(map.get(j) > 1){//不止一个j，整体左移窗口，移除left指针的元素
                char i = s.charAt(left);//拿到left位置的元素
                map.put(i, map.get(i) - 1);//left位置的元素的个数减1
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring(new String("abcabcbb"));
    }
}
