// Letter Combinations of a Phone Number


// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

// Code:

import java.util.*;  

class Solution {
    public List<String> letterCombinations(String digits) {
        String[][] letters=new String[][]{{"a" ,"b" ,"c"},
            {"d" ,"e" ,"f"},
            {"g" ,"h" ,"i"},
            {"j" ,"k" ,"l"},
            {"m" ,"n" ,"o"},
            {"p", "q" ,"r", "s"},
            {"t","u","v"},
            {"w","x","y","z"}
        };
        List<String> output=new ArrayList<String>();  
        for(int i=0;i<digits.length();i++)
        {
            int listPos=Character.getNumericValue(digits.charAt(i))-2;
            if(i==0)
            {
                for (String newch :letters[listPos] )
                output.add(newch);
            }
            else
            {
                int outputsize=output.size();
                for(int j=0;j<outputsize;j++)
                {
                    String temp=output.get(0);
                    output.remove(0);
                    for (String newch :letters[listPos] )
                        output.add(temp+newch);
                }
            }
        }

        return output;
    }
}