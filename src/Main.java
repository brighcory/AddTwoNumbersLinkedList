/**
 * Created by cory on 11/17/17.
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next = new ListNode(4);
        Solution solution = new Solution();
        solution.addTwoNumbers(l1, l2);
        System.out.println();
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1.val = l1.val + l2.val;
        if(l1.val>=10){
            l1.val %= 10;
            if (l1.next == null){
                l1.next = new ListNode(1);
            }else{
                l1.next.val += 1;
                if (l1.next.val >= 10 && l2.next == null){
                    l1.next = addTwoNumbers(l1.next, new ListNode(0));

                }
            }
        }
        if (l1.next != null && l2.next != null){
            l1.next = addTwoNumbers(l1.next, l2.next);

        }else if(l1.next == null && l2.next != null){
            l1.next = l2.next;
        }

        return l1;
    }

}