/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int 0val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode first = l1;
        ListNode second = l2;
        ListNode prev = null;
        ListNode ans = null;
        ListNode tail = null;
        int sum=0,carry=0;
        while(first!=null && second!=null){
            sum = first.val+second.val+carry;
            carry = sum/10;
            sum = sum%10;
            ListNode temp = new ListNode(sum);
            if(ans==null){
              ans = temp;
              tail = ans;
            }else{
                tail.next = temp;
                tail = temp;
            }
            first = first.next;
            second= second.next;
        }
        ListNode firstOrSecond = first==null?second:first;
         while(firstOrSecond!=null){
            sum = firstOrSecond.val+carry;
            carry = sum/10;
            sum = sum%10;
            ListNode temp = new ListNode(sum);
            tail.next = temp;
            tail = temp;
            firstOrSecond = firstOrSecond.next;
        }
         
        if(carry==1){
             ListNode temp = new ListNode(1);
             tail.next = temp;
        }
return ans;
    }
}