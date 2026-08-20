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
    public ListNode rotateRight(ListNode head, int k) {
      if(head == null || head.next == null){
        return head;
      }

      int length=1;
    ListNode last=head;
    while(last.next != null){
        last=last.next;
        length++;
    }
    last.next=head;
    
    k=k%length;
    int steps=length-k;
    ListNode newtail=last;
   
    while(steps-- >0){
        newtail=newtail.next;

    }

    ListNode NewHead=newtail.next;
    newtail.next=null;

    return NewHead;
    }
}