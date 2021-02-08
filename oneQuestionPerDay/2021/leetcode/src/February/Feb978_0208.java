package February;

/**
 * 978. 最长湍流子数组     难度：easy
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * 返回 A 的最大湍流子数组的长度。
 *
 *
 * 示例 1：
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 *
 * 示例 2：
 * 输入：[4,8,12,16]
 * 输出：2
 *
 * 示例 3：
 * 输入：[100]
 * 输出：1
 */

/**
 * 思路：根据题意，要求的为最大连续波浪数段，即交替上升下降。
 * 想到动态规划，无论是上升也好，下降也好，都是一段一段往已有的后面添加，只求最大长度不求具体是那些，用动态规划
 *
 * 状态转移方程设计：
 *      increase[i]表示为:    以arr[i]结尾，且arr[i - 1] < arr[i]的子数组长度(即此时最后一段为上升段)
 *      decrease[i]表示为：   以arr[i]结尾，且arr[i - 1] > arr[i]的子数组长度(即此时最后一段为下降段)
 *
 *      方程为：
 *      若arr[i - 1] < arr[i],increase[i] = decrease[i - 1] + 1
 *      若arr[i - 1] > arr[i],decrease[i] = increase[i - 1] + 1
 *
 * 初始化：只有一个元素的时候，湍流子数组的长度是 1
 */
public class Feb978_0208 {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if(len < 2){
            return len;
        }
        //初始化
        int[] increase = new int[len];
        int[] decrease = new int[len];
        increase[0] = 1;
        decrease[0] = 1;

        //结果集
        int ans = 1;

        for(int i = 1; i < len; i++){
            if(arr[i - 1] < arr[i]){
                increase[i] = decrease[i - 1] + 1;
                decrease[i] = 1;
            }else if(arr[i - 1] > arr[i]){
                decrease[i] = increase[i - 1] + 1;
                increase[i] = 1;
            }else{
                increase[i] = 1;
                decrease[i] = 1;
            }
            ans = Math.max(ans, Math.max(increase[i],decrease[i]));
        }

        return ans;
    }
}
