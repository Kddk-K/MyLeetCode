package Other.array;

/**旋转数组  难度：medium
 *
 *给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *  
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */

/**
 * 思路：翻转数组
 *
 *             nums = "----->-->"; k =3
 *             result = "-->----->";
 *
 *             reverse "----->-->" we can get "<--<-----"
 *             reverse "<--" we can get "--><-----"
 *             reverse "<-----" we can get "-->----->"
 *
 *
 */
public class Array189 {
    public void rotate(int[] nums, int k) {

        //若没有取余操作，则会数组越界，原因是k的值大于数组长度。
        k %= nums.length;
        //翻转整个数组
        reverse(nums, 0, nums.length - 1);
        //翻转前k个元素
        reverse(nums, 0, k - 1);
        //翻转剩下的元素
        reverse(nums, k, nums.length - 1);
    }

    //翻转方法
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
