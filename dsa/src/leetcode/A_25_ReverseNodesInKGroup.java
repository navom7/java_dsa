package leetcode;


/*
25. Reverse Nodes in k-Group
Solved
Hard
Topics
Companies
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

 TODO: Tricky Part is solving in O(1) Space i.e. iterative approach
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class A_25_ReverseNodesInKGroup {
    ListNode reverse(ListNode prev, ListNode curr, ListNode nxt) {
        while(curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }

    ListNode findKthNode(ListNode head, int k) {
        ListNode end = head;

        for(int i = 0; i < k-1; i++) {
            if(end == null) {
                break;
            }
            end = end.next;
        }
        return end;
    }

    ListNode reverseK(ListNode head, int k) {
        ListNode last = findKthNode(head, k);
        if(last == null) {
            return head;
        }
        ListNode nextHead = last.next;
        last.next = null;
        ListNode tail = head;
        ListNode newHead = reverse(null, head, head);

        tail.next = reverseK(nextHead, k);

        return newHead;


    }

    //TODO: Most optimised solution O(N) & O(1)
    ListNode reverseKIterative(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);

        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while(head != null) {
            ListNode last = findKthNode(head, k);
            if(last == null) {
                break;
            }
            ListNode nextHead = last.next;
            last.next = null;

            ListNode tail = head;

            ListNode newHead = reverse(null, head, head);

            prevGroupEnd.next = newHead;

            tail.next = nextHead;
            prevGroupEnd = tail;
            head = nextHead;

        }


        return dummy.next;

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseKIterative(head, k);
    }








}