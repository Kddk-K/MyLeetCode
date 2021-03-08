package Other.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列      难度：medium
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class backtrack46 {
    //思路：回溯，将题目给定的 nn 个数的数组 \textit{nums}nums 划分成左右两个部分，左边的表示已经填过的数，右边表示待填的数，
    // 我们在回溯的时候只要动态维护这个数组即可。
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        //结果集排列
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //当前排列
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        backtrack(len, output, res, 0);
        return res;
    }

    public void backtrack(int len, List<Integer> output, List<List<Integer>> res, int first){
        // 所有数都填完了
        if (first == len) {
            res.add(new ArrayList<Integer>(output));
        }
        //填到first个位置，当前排列
        for(int i = first; i < len; i++){
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(len, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
