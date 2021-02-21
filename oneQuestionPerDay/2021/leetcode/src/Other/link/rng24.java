package Other.link;

/**
 * 剑指 Offer 24. 反转链表    难度：easy
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */


public class rng24 {
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        while(head != null){
            ListNode q = head.next;//暂存后继结点
            head.next = p;//修改next指向
            p = head;//p暂存head
            head = q;//访问下一结点
        }
        return p;
    }
}
