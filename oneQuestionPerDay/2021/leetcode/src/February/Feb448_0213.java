package February;

/**
 * 448. 找到所有数组中消失的数字    难度：easy
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：抽屉原理+异或运算。
 *      抽屉原理：抽屉原理的一般含义为：“如果每个抽屉代表一个集合，
 *      每一个苹果就可以代表一个元素，假如有 n + 1 个元素放到 n 个集合中去，
 *      其中必定有一个集合里至少有两个元素。” 抽屉原理有时也被称为鸽巢原理。它是组合数学中一个重要的原理。
 *      原地哈希函数：f(num[i]) = num[i] - 1
 *
 *      交换两个位置的元素但不能使用额外空间，想到用异或运算，异或运算是不进位的二进制加法，性质如下：
 *          若a ^ b = c,那么a ^ c = b 与 b ^ c = a 同时成立，即可交换两个变量的值
 *          如交换a与b的值可以这样做：
 *              a = a ^ b;
 *              b = a ^ b;
 *              a = a ^ b;
 *          注意：在数组中使用异或运算交换两个变量的值的时候，一定要保证这两个变量不是同一个变量，即索引不能相同，
 *          否则会把这个位置上的数变成0
 *
 */
public class Feb448_0213 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            /**
             * 说明：因为给的数组从1开始，索引从0开始，就看给的用例：
             *          4,3,2,7,8,2,3,1
             * 索引是:   0,1,2,3,4,5,6,7
             * 遍历数组，目的是让nums[i]位于nums[i] - 1上，如让1位于索引0上，4位于索引3上
             * 假设下次遍历到的元素是4，此时需要确认索引位置为3的元素是不是4，若不是4，就把看到的4换到索引3上
             * 此时变为  7,3,2,4,8,2,3,1
             * 下次遍历到的元素是3，而索引为2上的元素不是3，交换
             *    变为： 7,2,3,4,8,2,3,1
             *
             */
            while(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        /**
         * 到此得到的是交换完成的数组，若i索引上的值不为i + 1，说明缺少了i+1这一元素
         */
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                ans.add(i + 1);
            }
        }
        System.out.println(ans);
        return ans;

    }
    public static void swap(int[] nums, int index1, int index2){
        if(index1 == index2){
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }

    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
}
