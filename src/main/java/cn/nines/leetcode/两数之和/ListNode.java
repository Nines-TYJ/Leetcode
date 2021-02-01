package cn.nines.leetcode.两数之和;

/**
 * 单向链表
 *
 * @author TYJ
 * @date 2021/1/25 17:16
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
