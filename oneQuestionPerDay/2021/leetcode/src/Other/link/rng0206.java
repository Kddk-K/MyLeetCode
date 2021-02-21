package Other.link;

/**
 * 面试题 02.06. 回文链表  难度：easy
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 示例 1：
 * 输入： 1->2
 * 输出： false
 *
 * 示例 2：
 * 输入： 1->2->2->1
 * 输出： true
 */

//思路：翻转后半部分链表，和前半部分比较，相同则是回文
//快慢指针找到链表中点，将链表分成两半
public class rng0206 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){//偶数个结点，翻转后n/2个结点
            fast = fast.next.next;//快指针一次移动两个结点
            slow = slow.next;//慢指针一次移动一个结点
        }
        if(fast != null && fast.next == null){//奇数个结点，翻转后n/2 - 1个结点，如 1 2 3 2 1 翻转 2 1
            slow = slow.next;
        }
        //此时slow指针已经移动到链表的n/2 + 1处
        slow = reverse(slow);

        fast = head;
        while(slow != null){
            if(fast.val != slow.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode p = null;
        while(head != null){
            ListNode q = head.next;
            head.next = p;
            p = head;
            head = q;
        }
        return p;
    }
}
