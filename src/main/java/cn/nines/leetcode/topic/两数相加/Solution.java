package cn.nines.leetcode.topic.两数相加;

import cn.nines.leetcode.topic.两数之和.ListNode;

/**
 * 2. 两数相加
 *
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * @author TYJ
 * @date 2021/1/25 17:12
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))))))))));
        ListNode l2 = new ListNode(9, null);
        ListNode result = addTwoNumbers(l1, l2);
        while (true){
            System.out.println(result.val);
            if (result.next == null){
                break;
            }
            result = result.next;
        }
    }

    /**
     * 复杂度分析
     * 时间复杂度：O(max(m,n))，其中 m,n 为两个链表的长度。我们要遍历两个链表的全部位置，而处理每个位置只需要 O(1) 的时间。
     * 空间复杂度：O(max(m,n))。答案链表的长度最多为较长链表的长度 +1。
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = null, temp = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0){
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            if (temp == null){
                temp = new ListNode(sum % 10);
                head = temp;
            }else {
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        return head;
    }

}