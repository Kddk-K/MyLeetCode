package March;

import Other.link.ListNode;
/**
 * 92. 反转链表 II  难度：medium
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Mar92_0318 {
    //思路：朴素解法，哨兵指针
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //哨兵指针，指向头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        //遍历到left指针所处位置，之后开始翻转
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //定义两个指针，一前一后遍历到right指针
        ListNode a = pre.next;
        ListNode b = a.next;

        for (int i = 0; i < right - left; i++) {
            //翻转
            ListNode temp = b.next;
            b.next = a;
            a = b;
            b = temp;
        }
        //此时a处在right指针处，b处在right之后一个结点处
        //pre.next.next表示left指针的next结点，设为b
        pre.next.next = b;
        //pre的next指向a
        pre.next = a;

        //dummy的next即为整个链表
        return dummy.next;
    }
}

