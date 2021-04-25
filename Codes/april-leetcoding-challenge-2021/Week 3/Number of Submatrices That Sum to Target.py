#   Number of Submatrices That Sum to Target


# Given a matrix and a target, return the number of non-empty submatrices that sum to target.

# A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

# Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.

 

# Example 1:


# Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
# Output: 4
# Explanation: The four 1x1 submatrices that only contain 0.
# Example 2:

# Input: matrix = [[1,-1],[-1,1]], target = 0
# Output: 5
# Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
# Example 3:

# Input: matrix = [[904]], target = 0
# Output: 0
 

# Constraints:

# 1 <= matrix.length <= 100
# 1 <= matrix[0].length <= 100
# -1000 <= matrix[i] <= 1000
# -10^8 <= target <= 10^8
#    Hide Hint #1  
# Using a 2D prefix sum, we can query the sum of any submatrix in O(1) time. Now for each (r1, r2), we can find the largest sum of a submatrix that uses every row in [r1, r2] in linear time using a sliding window.

# Code

class Solution(object):
    def numSubmatrixSumTarget(self, matrix, target):
        count=0
        matrixLength=len(matrix[0])
        matrixWidth=len(matrix)
        res=defaultdict(int)

        for rows in matrix:
            for i in range(1, matrixLength):
                rows[i] =rows[i]+ rows[i-1]
        for i in range(matrixLength):
            for j in range(i, matrixLength):
                res.clear()
                res[0], sumEle = 1, 0
                for k in range(matrixWidth):
                    sumEle =sumEle+ matrix[k][j] - (matrix[k][i-1] if i else 0)
                    count =count+ res[sumEle - target]
                    res[sumEle] =res[sumEle]+ 1
        return count