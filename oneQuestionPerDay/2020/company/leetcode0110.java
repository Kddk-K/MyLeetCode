package com.company;

import java.util.ArrayList;
import java.util.List;

public class leetcode0110 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 5, 6};
        summaryRanges(nums);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int first = 0;
        int second = 0;
        while (second < nums.length) {
            // second向后遍历，直到不满足连续递增(即 nums[second] + 1 != nums[second + 1])
            // 或者second达到数组边界，则当前连续递增区间 [first,second] 遍历完毕，将其写入结果列表。
            if (second + 1 == nums.length || nums[second] + 1 != nums[second + 1]) {
                //将区间[first,second]写入结果集
                StringBuffer sb = new StringBuffer();
                if (nums[first] == nums[second]) {
                    sb.append(nums[first]);
                } else if (nums[first] != nums[second]) {
                    sb.append(nums[first]).append("->").append(nums[second]);
                }
                res.add(sb.toString());
                //将first更新为second的下一个位置，作为区间的起始位置
                first = second + 1;
            }
            second++;
        }
        return res;
    }
}
