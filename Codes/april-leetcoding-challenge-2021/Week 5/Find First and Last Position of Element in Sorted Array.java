// Find First and Last Position of Element in Sorted Array

// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109

// Code:

class Solution {
    int target;
    int[] sol = new int[]{-1,-1};
    int [] nums;
    public void eval(int start,int end){
        if (start>end)
            return;
        if(nums[(start+end)/2]>=target){
            eval(start,((start+end)/2)-1);
        }
        
        
        if(nums[(start+end)/2]<=target){
            eval(((start+end)/2)+1,end);
        }
        if(nums[(start+end)/2]==target){
            if(sol[0]==-1 || sol[0]>(start+end)/2)
                sol[0]=(start+end)/2;
            if(sol[1]<(start+end)/2)
                sol[1]=(start+end)/2;
        }
        
        
        
    }
    public int[] searchRange(int[] nums, int target) {
        this.target=target;
        this.nums=nums;
        if (nums.length!=0)
            eval(0,nums.length-1);
        
        return sol;
        
    }
}