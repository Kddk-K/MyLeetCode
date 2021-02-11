package February;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素    难度：easy
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 *
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 */

//解题思路：TopK问题，使用优先队列，优先队列默认小根堆，即堆顶元素是堆中最小的元素。
// 用优先队列维护前k大的元素，队首保存的为这k个元素中最小的元素，即第k大的元素
// add时，当数据不足k位，直接加入队列；若数据满k位，且插入数据大于队首元素时，说明此时的队首元素不再是第k大的元素，因此将队首元素poll掉
// 并加入插入数据；数据小于队首元素时，则此元素不可能成为第k大的元素。

public class Feb703_0211 {

    private int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>(); //默认小根堆
    /**
     * 初始化数组
     * @param k
     * @param nums
     */
    public Feb703_0211(int k, int[] nums) {
        this.k = k;//局部变量
        for(int num : nums){
            add(num);
        }
    }

    /**
     * 插入val，并返回第k大元素
     * @param val
     * @return
     */
    public int add(int val) {
        if(pq.size() < k){
            pq.add(val);
        }else if(val > pq.peek()){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
