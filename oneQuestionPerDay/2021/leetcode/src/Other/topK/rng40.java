package Other.topK;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数  难度：easy
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class rng40 {
    public static int[] getLeastNumbers(int[] arr, int k){
        int[] res = new int[k];
        //优先队列默认是小根堆,即最小元素在堆顶,要求最小的k个数，则应变成大根堆，重写比较器
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 0; i < k; i++){
            pq.add(arr[i]);
        }
        for(int i = k; i < arr.length; i++){
            //若堆顶元素大于当前元素，则证明有更小的元素，因此将堆顶元素弹出，将当前元素入堆
            if(pq.peek() > arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        for (int i : res) {
            System.out.print(i + " ");
        }
        return res;
    }

    public static void main(String[] args) {
        getLeastNumbers(new int[]{4, 5, 1, 6, 2, 7, 3, 8},4);
    }
}
