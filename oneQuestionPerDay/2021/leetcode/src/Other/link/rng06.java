package Other.link;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 */
public class rng06 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    //思路1：翻转链表后，将链表转为数组
    //思路2：利用栈的FILO，直接翻转
    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int len = stack.size();
        int[] ans = new int[len];
        for(int i = 0; i < len; i++){
            ans[i] = stack.pop().val;
        }
        return ans;
    }
        public int[] reversePrint(ListNode head) {
            ListNode p = null;
            while(head != null){
                ListNode q = head.next;
                head.next = p;
                p = head;
                head = q;
            }
            return listNodeToArrays(p);
        }
        /*数组转链表
        public ListNode arrayToListNode(int[] s) {
            ListNode root = new ListNode(s[0]);
            ListNode other = root;
            for (int i = 1; i < s.length; i++) {
                ListNode temp = new ListNode(s[i]);
                other.next = temp;
                other = temp;
            }
            return root;
        }*/
        public int[] listNodeToArrays(ListNode l){
            int size = listNodeSize(l);
            int[] ints = new int[size];
            int index = 0;
            while (l != null) {
                ints[index] = l.val;
                l = l.next;
                index++;
            }
            return ints;
        }
        //求链表的长度
        public int listNodeSize(ListNode l) {
            int size = 0;
            while (l != null) {
                size++;
                l = l.next;
            }
            return size;
        }
    }
