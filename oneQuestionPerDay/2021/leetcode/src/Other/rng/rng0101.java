package Other.rng;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 01.01. 判定字符是否唯一      难度：easy
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: false
 * <p>
 * 示例 2：
 * 输入: s = "abc"
 * 输出: true
 * <p>
 * 限制：
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 */
public class rng0101 {
    //思路：hashSet，将字符串的每个元素存入hashSet，利用set自动去重，比较长度

    //提交通过，题目要求不适用额外数据结构会很加分，考虑其他做法
    /*public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < chars.length; i++){
            set.add(chars[i]);
        }
        if(set.size() == chars.length){
            return true;
        }
        return false;
    }*/

    //想想位运算怎么做
    public boolean isUnique(String astr) {
        /**
         * 定义一个bits为0，以二进制的形式存在，0代表不存在，1代表存在，例如：若字符串为abce，对应的bits就为10111（edcba）
         * 定义一个位移量move，为某个字符与A元素的距离
         * 用1L左移move位，表示当前元素存在，再将bits与运算结果逻辑与运算，判断是否为0，逻辑与运算，全1才为1，若是第一次遍历到当前元素，
         * 则逻辑或运算，并赋值给bits，更新bits的值
         */
        Long bits = 0L;
        for (int i = 0; i < astr.length(); i++) {
            //计算字符与‘A'之间的距离
            int move = astr.charAt(i) - 'A';
            if ((bits & (1L << move)) != 0) {
                return false;
            } else {
                bits |= (1L << move);
            }
        }
        return true;
    }
}
