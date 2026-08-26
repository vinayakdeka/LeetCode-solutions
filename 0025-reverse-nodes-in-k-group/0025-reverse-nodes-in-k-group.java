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
    public ListNode reverseKGroup(ListNode head, int k) {
        // check if k nodes exist or not
        int cnt = 0;
        ListNode temp = head;
        while(cnt<k)
        {
            if(temp==null)
            return head;
            cnt++;
            temp = temp.next;
        }

        // reverse the remaining half of the k elements
        ListNode prevNode = reverseKGroup(temp,k);

        // reverse the current group 
        temp = head;
        cnt = 0;
        while(cnt<k)
        {
          ListNode next = temp.next;
          temp.next = prevNode;
          prevNode = temp;
          temp = next;
          cnt++;
        }
        return prevNode;
    }
}