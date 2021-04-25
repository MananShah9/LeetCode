// Palindrome Linked List

// Given the head of a singly linked list, return true if it is a palindrome.

 

// Example 1:


// Input: head = [1,2,2,1]
// Output: true
// Example 2:


// Input: head = [1,2]
// Output: false
 

// Constraints:

// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9
 

// Follow up: Could you do it in O(n) time and O(1) space?




// Code:

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
        int noOfElements =1;
        ListNode currentElement= new ListNode();
        currentElement=head;
        while(currentElement.next!=null){
            noOfElements++;
            currentElement=currentElement.next;
        }
        int tempArray[]=new  int[noOfElements];
        for(int i=0;i<noOfElements/2;i++){
            tempArray[i]=head.val;
            head=head.next;
        }
        if(noOfElements%2==1)
            head=head.next;
        for(int i=(noOfElements)/2-1;i>=0;i--){
            if(tempArray[i]!=head.val)
                return false;
                        head=head.next;

        }
        return true;
    }
}