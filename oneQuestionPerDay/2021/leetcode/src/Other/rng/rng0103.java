package Other.rng;

/**
 * 面试题 01.03. URL化
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 示例 1：
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 *
 * 示例 2：
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 */
public class rng0103 {
    //思路：倒序遍历，碰到空格就转换成%20三个字符。
    //由于给定了真实长度，就从真实长度处开始向前遍历，维护两个指针
    public static String replaceSpaces(String S, int length) {
        int i = S.length() - 1;
        int j = length - 1;
        char[] c = S.toCharArray();
        while (j >= 0){
            if(c[j] == ' '){//倒序替换
                c[i--] = '0';
                c[i--] = '2';
                c[i--] = '%';
            }else {//不是空格就直接赋值
                c[i--] = c[j];
            }
            j--;
        }
        //String.valueOf(char[] data, int offset, int count) : 将 char 数组 data 中 由 data[offset] 开始取 count 个元素 转换成字符串
        return String.valueOf(c,i + 1,S.length() - i - 1);
    }

    public static void main(String[] args) {
        replaceSpaces("Mr John Smith", 13);
    }
}
