package March;

import java.util.Stack;

/**
 * 227. 基本计算器 II    难度：medium
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * <p>
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 * <p>
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 */
public class Mar227_0311 {
    //思路：加减乘除无括号无负数计算器，用一个栈即可实现。
    //先将字符串转为字符数组，逐位判断，若是数字，则将字符或连续数字字符转为整数，在判断此数前是何符号；
    //若是+号，则将此数入栈，若是—号，则将次数的相反数入栈，
    //若是*号，则计算栈顶元素与此数的乘积结果，再入栈，若是/号，则计算栈顶元素与此数之商再入栈。
    //这样就得到了只含+-操作的栈。
    //细节：定义一个sign表示第一个数之前的符号为+，每次若遍历到符号位，则更新sign

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        char[] c = s.toCharArray();
        int num = 0;//当前数
        char sign = '+';//上一个符号位
        for (int i = 0; i < len; i++) {
            if(c[i] == ' ')continue;
            if (c[i] >= '0') {
                num = 10 * num + (c[i] - '0');//处理连续数字字符
                //continue; 不能加continue
            }
            if (!Character.isDigit(c[i]) || i == c.length - 1) {//不是数字
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c[i];//更新sign为当前字符
                num = 0;//更新num为0
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        calculate("3 + 5 / 2");
    }
}
