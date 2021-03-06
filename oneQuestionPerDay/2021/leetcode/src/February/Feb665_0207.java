package February;

/**
 * 665. 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 示例 1:
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *
 * 示例 2:
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 */

/**
 * 思路：
 * 一，当数组长度小于 3 时，最多需要调整一次就能满足条件
 * 二，当数组长度大于等于 3 时，出现前一个元素 y 大于后一个元素z时，
 *    如果 y 的前元素 x 不存在，让 y=z 即可；若 x 存在，会有以下情况
 *
 * x    y   z
 * 1    3   2
 * 2    3   1
 * 3    3   1
 * 2    3   2
 * 要满足条件，需要如下调整：
 * 1，当 x<z，让 y=z
 * 2，当 x>z，让 z=y
 * 3, 当 x=z，让 y=z
 * 综合以上可以得到：当 x 存在且 x>z，就让 z=y，否则让 y=z
 * 当变更超过 2 次就不再满足条件
 */
public class Feb665_0207 {
    public boolean checkPossibility(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){//当前元素大于后继元素
                count++;//计数+1，开始调整
                if(count > 1){
                    return false;
                }
                if(i - 1 >= 0 && nums[i - 1] > nums[i + 1]){//前继元素大于后继元素，如2，3，1
                    nums[i + 1] = nums[i];//将当前元素赋值给后继元素变为2，3，3
                }else{//前继元素小于或等于后继元素，如1，3，2
                    nums[i] = nums[i + 1];//将后继元素的值赋给当前元素，变为1，3，3
                }
            }
        }
        return count < 2;
    }
}
