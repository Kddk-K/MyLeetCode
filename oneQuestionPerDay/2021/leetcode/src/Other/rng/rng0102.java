package Other.rng;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.02. 判定是否互为字符重排    难度：easy
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * <p>
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * <p>
 * 说明：
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 */
public class rng0102 {
    //思路：此题就是判断两个字符串的组成元素是否完全相同，想到用两个hashMap集合存每个元素及其出现的次数，比较两个集合是否相等
    public static boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> hp1 = new HashMap<>();
        Map<Character, Integer> hp2 = new HashMap<>();
        if (s1.length() != s2.length()) {
            System.out.println("false");
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            hp1.put(c1[i], hp1.getOrDefault(c1[i], 0) + 1);
        }
        for (int i = 0; i < c2.length; i++) {
            hp2.put(c2[i], hp2.getOrDefault(c2[i], 0) + 1);
        }
        if(hp1.equals(hp2)){
            System.out.println("true");
            return true;
        }else{
            System.out.println("false");
            return false;
        }

    }

    public static void main(String[] args) {
        CheckPermutation("aac","cca");
    }
}
