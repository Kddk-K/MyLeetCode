package February;

/**
 * 896. 单调数列    难度：easy
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 *
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 *
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 *
 * 示例 4：
 * 输入：[1,2,4,5]
 * 输出：true
 *
 * 示例 5：
 * 输入：[1,1,1]
 * 输出：true
 */
public class Feb896_0228 {
    public static boolean isMonotonic(int[] A) {
        //第一个数小于或等于最后一个数时,升序
        if(A[0] <= A[A.length - 1]){
            for(int i = 0; i < A.length - 1; i++){
                if(A[i + 1] < A[i]){
                    System.out.println("false");
                    return false;
                }
            }
        }else{//降序
            for(int i = 0; i < A.length - 1; i++){
                if(A[i + 1] > A[i]){
                    System.out.println("false");
                    return false;
                }
            }
        }
        System.out.println("true");
        return true;
    }

    public static void main(String[] args) {
        isMonotonic(new int[]{1,4,4,5});
    }
}
