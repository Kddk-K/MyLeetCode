package March;

import java.util.Stack;

/**
 * 224. 基本计算器       难度：hard
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 *
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 *
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */
public class Mar224_0310 {
    //思路：用一个栈依次存入字符。
    //定义三个变量：res表示计算结果；sign表示运算符；num表示当前数字
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);//初始化符号为'+'
        int len = s.length();
        char[] c = s.toCharArray();
        int res = 0, sign = 1, num = 0;
        for(int i = 0; i < len; i++){
            if(c[i] == ' '){
                continue;
            }else if(c[i] >= '0'){
                num = 10 * num + (c[i] - '0');
                continue;
            }
            res += num * sign;
            num = 0;
            if(c[i] == '+'){
                sign = stack.peek();
            }else if(c[i] == '-'){
                sign = -stack.peek();
            }else if(c[i] == '('){
                stack.push(sign);
            }else if(c[i] ==')'){
                stack.pop();
            }
        }
        res += num * sign;
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        calculate("(1+(4+5+2)-3)+(6+8)");
    }
}
