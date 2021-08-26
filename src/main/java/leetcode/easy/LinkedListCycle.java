package leetcode.easy;

import java.util.Set;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();

        //head = [3,2,0,-4], pos = 1
        ListNode head = new ListNode(3);
        ListNode follow = head;
        follow.next = new ListNode(2);
        follow = follow.next;
        ListNode pos = follow;
        follow.next = new ListNode(0);
        follow = follow.next;
        follow.next = new ListNode(-4);
        follow = follow.next;
        follow.next = pos;
        System.out.println(linkedListCycle.hasCycle(head) == true);

        //head = [1,2], pos = 0
        head = new ListNode(1);
        follow = head;
        follow.next = new ListNode(2);
        follow.next = head;
        System.out.println(linkedListCycle.hasCycle(head) == true);

        //head = [1], pos = -1
        head = new ListNode(1);
        System.out.println(linkedListCycle.hasCycle(head) == false);
    }
    public boolean hasCycle(ListNode head) {


        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;

            if(slow  == fast){
                return  true;
            }
        }

        return false;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
