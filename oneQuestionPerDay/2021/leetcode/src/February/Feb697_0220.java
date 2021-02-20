package February;

/**
 * 697. 数组的度        难度：easy
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1：
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * <p>
 * 示例 2：
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 */

import java.util.HashMap;
import java.util.Map;

/**思路：1、先求原数组的度，即出现最多次数元素的次数
 *      2、再求与原数组有相同度的最短子数组
 *
 *      用哈希存元素和其出现的次数，哈希中次数的最大值就是数组的度
 *      要求最短的子数组由出现最多次数的元素的首次和最后一次的位置决定，若有多个度，则需取子数组的最小值
 */

public class Feb697_0220 {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();//计数，记录每个元素及其出现的次数
        Map<Integer, Integer> first = new HashMap<>();//记录出现最多元素在整个数组中首次出现的位置
        Map<Integer, Integer> last = new HashMap<>();//记录出现最多元素在整个数组中最后一次出现的位置

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int p = nums[i];
            cnt.put(p, cnt.getOrDefault(p, 0) + 1);//cnt记录每个元素及其出现的次数，若重复元素则加1
            max = Math.max(max, cnt.get(p));//更新出现的最大次数
            if (!first.containsKey(p)) {//首次出现p，存入first中
                first.put(p, i);
            }
            last.put(p, Math.max(last.getOrDefault(p, -1), i));//last中存的i代表遍历到当前i位置时，该元素不是首次出现，将他的下下标存起来，即最后出现的位置
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int p = nums[i];
            if (cnt.get(p) == max) {
                ans = Math.min(ans, last.get(p) - first.get(p) + 1);
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        findShortestSubArray(new int[]{1,2,2,3,1,4,2});
    }
}
