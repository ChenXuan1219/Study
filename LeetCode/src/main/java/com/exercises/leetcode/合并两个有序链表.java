package com.exercises.leetcode;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/21 23:44
 */
public class 合并两个有序链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode q1 = new ListNode(2);
        ListNode q2 = new ListNode(4);
        ListNode q3 = new ListNode(3);
        ListNode t1 = new ListNode(5);
        ListNode t2 = new ListNode(6);
        ListNode t3 = new ListNode(4);
        q1.next = q2;
        q2.next = q3;

        t1.next = t2;
        t2.next = t3;

        removeNthFromEnd(l1, 2);
        ListNode pre = l1;
        while(pre != null){
            System.out.println(pre.val);
            pre = pre.next;
        }




    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode cur = temp;
        while (l1 == null || l2 == null){
            cur.val = (l1.val + l2.val) % 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        return dfs(temp);
    }

    ListNode dfs(ListNode head){
        ListNode pre = head;
        ListNode cur = null;
        while (cur != null){
            ListNode next = pre.next;
            pre.next = pre;
            cur = pre;
            pre = next;
        }
        return cur;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        if (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;

            curr = next;
        }
        return prev;

    }

    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        ListNode next;
        //每次循环，都将当前节点指向它前面的节点
        //然后当前节点和前节点后移
        while (curr != null) {
            //临时节点，暂存当前节点的下一节点，用于后移
            //因为接下来curr.next进行赋值后将会断链
            next= curr.next;
            //将当前节点指向它前面的节点
            curr.next = prev;
            //前指针后移
            prev = curr;
            //当前指针后移
            curr = next;
        }
        return prev;
    }


    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        while(head != null){
            ListNode last = Last(head);
            if(head != last) return false;
            head = head.next;
        }

        return true;
    }

    static ListNode Last(ListNode head){
        while(head.next != null) {
            head = head.next;
        }
        return head;
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode pos = head;

        int count = 0;
        while (pre != null) {
            if (count != n) {
                pre = pre.next;
            }

        }

        return pre;




    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int carrry = 0;
        ListNode result = new ListNode();
        ListNode pre = result;
        while(l1 != null && l2 != null){

            int sum = 0 ;
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            if(n1 + n2 + carrry >= 10){
                sum = (n1 + n2 + carrry) / 10;
                carrry = sum / 10;
            }else{
                sum = n1 + n2 + carrry;
                carrry = 0;
            }
            pre.next =  new ListNode(sum);
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;

        }

        return result.next;
    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


}
