package February;

/**
 * 1004. 最大连续1的个数 III       难度：medium
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 * 示例 1：
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 示例 2：
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 */
public class Feb1004_0219 {
    public static int longestOnes(int[] A, int K) {
        int ans = 0;
        int left = 0, right = 0;//双指针
        int cnt = 0;//计数
        int len = A.length;
        for(int i = 0; i < len; i++){
            if(A[i] == 0){
                cnt++;
            }
            while(cnt > K){//计数大于K个此时，就必须从left指针处去掉一个0，即必须到left的下一个0处cnt减1
                if(A[left] == 0){
                    cnt--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);//先更新结果再移动right指针
            right++;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
    }
}
