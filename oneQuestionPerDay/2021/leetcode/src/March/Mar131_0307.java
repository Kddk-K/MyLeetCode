package March;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */

//思路：回溯
public class Mar131_0307 {

    List<List<String>> res;//保存所有搜索到的路径
    List<String> path;//保存一条路径
    int len;//字符串长度
    char[] arr;

    public List<List<String>> partition(String s) {
        //初始化
        res = new ArrayList<>();
        path = new ArrayList<>();
        len = s.length();
        arr = s.toCharArray();
        backtrack(0);
        return res;
    }

    //index为起始位置
    //回溯法
    public void backtrack(int index) {
        if (index == len) {
            res.add(new ArrayList<>(path));//深度拷贝
            return;
        }
        for (int i = index; i < len; i++) {
            if (isPalidrome(index, i)) {//若从索引0处到i处满足回文串
                path.add(new String(arr, index, i + 1 - index));
                backtrack(i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    //判断是否回文
    public boolean isPalidrome(int left, int right){
        while (left < right){
            if(arr[left] != arr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
