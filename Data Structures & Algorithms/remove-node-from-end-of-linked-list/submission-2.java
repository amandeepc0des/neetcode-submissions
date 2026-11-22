/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        int totalNodes = 1;
        int nthNode = 0;
        while(fast.next != null)
        {
            totalNodes++;
            fast = fast.next;
        }
        if(n == 1)fast = null;
        if(totalNodes - n == 0)return head.next;
        ListNode slow = head;
        while(slow != null)
        {
            nthNode++;
            if(totalNodes - n == nthNode)
            {
                ListNode one = slow.next;
                ListNode two = one.next;
                slow.next = two;
                break;
            }
            slow = slow.next;

        }
        return head;


    }
}
