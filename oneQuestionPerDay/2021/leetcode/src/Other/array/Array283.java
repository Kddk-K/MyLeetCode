package Other.array;

/**
 * 283. 移动零     难度：easy
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */

//思路：双指针
public class Array283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        //把所有非0的数复制到数组前面，j起计数作用
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        //将j以后的数全部置0
        for(int i = j; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
