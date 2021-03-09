package March;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项     难度：easy
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */
public class Mar1047_0309 {
    //思路：用一个栈来实现，若栈为空或当前遍历到的元素不等于栈顶元素，就把当前元素压入栈
    //否则说明栈中元素和当前元素是重复元素，则弹栈，遍历下一个元素
    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        int len = S.length();
        for(int i = 0; i < len; i++){
            if(stack.isEmpty() || S.charAt(i) != stack.peek()){
                stack.push(S.charAt(i));
            }else{
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        removeDuplicates("abbacaacc");
    }
}
