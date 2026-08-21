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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while( fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf=reverse(slow);

        ListNode first=head;

        while(secondHalf != null){
            if(first.val != secondHalf.val){
                return false;
            }
            first=first.next;
            secondHalf=secondHalf.next;
        }
        return true;
        
    }
    ListNode reverse(ListNode node){
        ListNode prev=null;
        ListNode current=node;
        while(current != null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    
    }
   
}