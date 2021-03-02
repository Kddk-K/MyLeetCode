package Other.rng;

/**
 * 面试题 01.09. 字符串轮转     难度：easy
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 *
 * 示例2:
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 *
 * 提示：
 * 字符串长度在[0, 100000]范围内。
 */
public class rng0109 {
    //妙招：先判断s1 s2长度是否相同，再判断s2 + s2中是否包含s1
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        String s = s2 + s2;
        return s.contains(s1);
    }
}
