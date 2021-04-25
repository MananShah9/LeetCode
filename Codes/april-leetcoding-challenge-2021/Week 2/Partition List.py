# Partition List

# Solution
# Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

# You should preserve the original relative order of the nodes in each of the two partitions.

 

# Example 1:


# Input: head = [1,4,3,2,5,2], x = 3
# Output: [1,2,2,4,3,5]
# Example 2:

# Input: head = [2,1], x = 2
# Output: [1,2]
 

# Constraints:

# The number of nodes in the list is in the range [0, 200].
# -100 <= Node.val <= 100
# -200 <= x <= 200

# Code:

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        temp=head
        output=[]
        output2=[]
        while temp!=None and temp.val<x:
            output.append(temp.val)
            temp=temp.next
        pos=len(output)
        if temp==None:
            return head
        while temp!=None:
            if(temp.val<x):
                output2.append(temp.val)
            else:
                output.append(temp.val)
            temp=temp.next
        temp=head
        for i in range(len(output2)):
            output.insert(pos,output2.pop())
        for i in range(len(output)):
            temp.val=output[i]
            temp=temp.next
        return head