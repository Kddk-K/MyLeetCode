package February;

import java.util.TreeMap;

/**
 * 1438. 绝对差不超过限制的最长连续子数组   难度：medium
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 * <p>
 * 示例 1：
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * <p>
 * 示例 2：
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * <p>
 * 示例 3：
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 */
public class Feb1438_0221 {
    //题意理解：存在一个子数组，该子数组的最大值与最小值的差小于或等于limit，返回这个子数组的长度最大值
    //思路：滑动窗口求窗口中最大值和最小值的差，用treeMap保存元素及其出现的次数
    //主动移动right指针，每移动一次就把nums[right]加入滑动窗口
    //被动移动left指针，判断窗口内最大值和最小值的差，若大于limit,则left右移，直至差值小于或等于limit，每移动一次，就将nums[left]的次数减小一次
    public static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> tp = new TreeMap<>();
        int left = 0, right = 0, ans = 0;
        while (right < nums.length) {
            //将right加入tp
            tp.put(nums[right], tp.getOrDefault(nums[right], 0) + 1);
            while (tp.lastKey() - tp.firstKey() > limit) {//TreeMap是排好序的去重的集合，判断若最大值与最小值之差大于limit，就右移左指针，同时减少nums[left]的次数
                tp.put(nums[left], tp.get(nums[left]) - 1);
                if (tp.get(nums[left]) == 0) {//若次数为0，则删除
                    tp.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5);
    }
}
