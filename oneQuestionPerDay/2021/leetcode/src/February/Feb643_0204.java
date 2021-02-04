package February;

/**
 * 643. 子数组最大平均数 I  难度：easy
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
 *
 * 示例：
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 * 提示：
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
//思路：双指针
public class Feb643_0204 {
    public double findMaxAverage(int[] nums, int k) {
        //双指针维护滑动窗口
        int left = 0, right = 0, max = -9999999, sum = 0;
        while(right < nums.length){
            while(right - left < k){
                sum = sum + nums[right];
                right++;
            }
            max = Math.max(max, sum);
            sum = sum - nums[left];
            left++;
        }
        return max * 1.0 / k;
    }
}
