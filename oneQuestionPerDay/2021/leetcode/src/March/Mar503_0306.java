package March;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II      难度：medium
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 *
 * 示例 1:
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 */
public class Mar503_0306 {
    //思路：单调栈，维护一个单调栈用来保存当前遍历到的索引，若栈为空，则将此元素放入栈内，若不为空，则比较当前元素和栈顶元素进行比较，
    //若当前元素大于栈顶元素，证明当前元素是前面所有元素的“下一个更大元素”，则把栈顶元素弹出，放入此较大的当前元素；
    //若当前元素小于栈顶元素，证明当前元素的“下一个更大元素”也是当前栈顶元素，则把当前元素入栈

    //细节：实现循环数组：遍历两次数组；取模可以把下标i映射到数组长度的0-N内
    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        //先将结果数组中的所有值设为-1
        Arrays.fill(ans, -1);
        //定义一个单调栈
        Stack<Integer> stack = new Stack<>();
        //遍历两个数组长度，相当于遍历循环数组
        for(int i = 0; i < len * 2; i++){
            //当栈不为空，且当前元素大于栈顶元素时，弹出栈顶元素，并放入当前元素
            while(!stack.isEmpty() && nums[i % len] > nums[stack.peek()]){
                //将当前值赋值给栈顶，加入结果数组
                ans[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        nextGreaterElements(new int[]{1,2,1,3,1});
    }
}
