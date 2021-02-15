package February;

/**
 * 485. 最大连续1的个数    难度：easy
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 */

//思路：双指针
public class Feb485_0215 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int l = 0, r = 0;
        while(r < nums.length){
            if(nums[r] == 1){//右指针为1就自加
                r++;
            }else{//若不为1，就更新到目前位置的ans为right-left
                ans = Math.max(ans, r - l);
                r++;
                l = r;
            }
            ans = Math.max(ans, r - l);
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1});
    }
}
