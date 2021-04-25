// Longest Increasing Path in a Matrix


// Given an m x n integers matrix, return the length of the longest increasing path in matrix.

// From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

// Example 1:


// Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
// Output: 4
// Explanation: The longest increasing path is [1, 2, 6, 9].
// Example 2:


// Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
// Output: 4
// Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
// Example 3:

// Input: matrix = [[1]]
// Output: 1
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 200
// 0 <= matrix[i][j] <= 231 - 1

// Code:

class Solution {
    int[][] dpMatrix;
    int matrixLength,matrixBreadth;
    int maxEle=0;
    public void findPair(int i,int j,int[][] matrix){
        dpMatrix[i][j]=1;
        int currentValue=matrix[i][j];
        
        if(i!=0 && matrix[i-1][j]>currentValue){
            if(dpMatrix[i-1][j]==0)
                findPair(i-1,j,matrix);
            
            dpMatrix[i][j]=Math.max(dpMatrix[i][j],dpMatrix[i-1][j]+1);
        }
        
        if(j!=0 && matrix[i][j-1]>currentValue){

            if(dpMatrix[i][j-1]==0)
                findPair(i,j-1,matrix);
            
            dpMatrix[i][j]=Math.max(dpMatrix[i][j],dpMatrix[i][j-1]+1);
        }
        
        if(i<matrixLength-1 && matrix[i+1][j]>currentValue){

            if(dpMatrix[i+1][j]==0)
                findPair(i+1,j,matrix);
            
            dpMatrix[i][j]=Math.max(dpMatrix[i][j],dpMatrix[i+1][j]+1);
            
        }
        if(j<matrixBreadth-1 && matrix[i][j+1]>currentValue){

            if(dpMatrix[i][j+1]==0)
                findPair(i,j+1,matrix);
            
            dpMatrix[i][j]=Math.max(dpMatrix[i][j],dpMatrix[i][j+1]+1);
        }

        maxEle=Math.max(maxEle,dpMatrix[i][j]);
    }
    public int longestIncreasingPath(int[][] matrix) {

        matrixLength=matrix.length;
        matrixBreadth=matrix[0].length;
        dpMatrix=new int[matrixLength][matrixBreadth];
        for(int i=0;i<matrixLength;i++)
            for(int j=0;j<matrixBreadth;j++)
                if(dpMatrix[i][j]==0)
                    findPair(i,j,matrix);
        return maxEle;

    }
}