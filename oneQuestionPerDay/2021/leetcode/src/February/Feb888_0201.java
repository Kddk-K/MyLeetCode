package February;

import java.util.Arrays;

/**
 * 888. 公平的糖果棒交换 难度：easy
 *
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 * 示例 1：
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 *
 * 示例 4：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]

 */

//思路：排序+双指针
public class Feb888_0201 {
    public int[] fairCandySwap(int[] A, int[] B) {
        //A的总和
        int sumA = 0;
        for(int i = 0; i < A.length; i++){
            sumA += A[i];
        }

        //B的总和
        int sumB = 0;
        for(int i = 0; i < B.length; i++){
            sumB += B[i];
        }

        //排序：
        Arrays.sort(A);
        Arrays.sort(B);

        //双指针：
        for(int i = 0; i <= A.length;){
            for(int j = 0; j <= B.length;){
                //如果Alice和bob交换了一个棒棒糖，以至于他们总量相等，则返回结果
                if(sumA - A[i] + B[j] == sumB - B[j] + A[i]){
                    return new int[]{A[i], B[j]};
                }else if(sumA - A[i] + B[j] < sumB - B[j] + A[i]){//如果小于，则相当于Alice给多了
                    j++;
                }else{
                    i++;
                }
            }
        }
        return new int[0];
    }
}
