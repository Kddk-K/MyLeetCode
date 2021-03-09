package Other.rng;

import java.util.Stack;

/**
 * 面试题 03.02. 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。
 * 执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * 示例：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class rng0302 {
    /**
     * initialize your data structure here.
     */

    //思路：定义两个栈，一个栈正常push，另一个每次只push最小值入栈
    //若用一个栈，则每次压两个数入栈，一个是当前元素，一个是当前最小元素，并动态更新最小值
    //出栈过程，若出栈的值等于最小值

    Stack<Integer> stack;
    Stack<Integer> assistStack;

    public rng0302() {
        //定义两个栈，一个正常压栈，一个辅助栈只压最小值
        stack = new Stack<>();
        assistStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        //若辅助栈为空或者辅助栈的栈顶元素大于x，则需将x压入辅助栈内
        if (assistStack.isEmpty() || assistStack.peek() >= x) {
            assistStack.push(x);
        }
    }

    public void pop() {
        //出栈过程中，若辅助栈的栈顶元素大于或等于主栈的值时，才能弹栈
        if (assistStack.peek() >= stack.pop()) {
            assistStack.pop();
        }
    }

    public int top() {
        return stack.pop();
    }

    public int getMin() {
        //最小值为辅助栈的栈顶元素
        return assistStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
