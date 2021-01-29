package Other;

/**只出现一次的数字  难度：easy
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */

//异或的思路，其余元素出现两次，那这些元素异或的结果必然为0，只需将数组中所有元素异或起来，得到的值就是只出现一次的元素
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
