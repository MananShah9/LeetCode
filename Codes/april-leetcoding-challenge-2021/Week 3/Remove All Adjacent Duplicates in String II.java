// Remove All Adjacent Duplicates in String II

// You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

// We repeatedly make k duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

// Example 1:

// Input: s = "abcd", k = 2
// Output: "abcd"
// Explanation: There's nothing to delete.
// Example 2:

// Input: s = "deeedbbcccbdaa", k = 3
// Output: "aa"
// Explanation: 
// First delete "eee" and "ccc", get "ddbbbdaa"
// Then delete "bbb", get "dddaa"
// Finally delete "ddd", get "aa"
// Example 3:

// Input: s = "pbbcggttciiippooaais", k = 2
// Output: "ps"
 

// Constraints:

// 1 <= s.length <= 105
// 2 <= k <= 104
// s only contains lower case English letters.
//    Hide Hint #1  
// Use a stack to store the characters, when there are k same characters, delete them.
//    Hide Hint #2  
// To make it more efficient, use a pair to store the value and the count of each character.

// Code

public class Entries{
    char charac;
    int occourances;
    public  Entries(char charac,int occourances){
        this.charac=charac;
        this.occourances=occourances;
    }
        
}

class Solution {
    public String removeDuplicates(String s, int k) {
        LinkedList<Entries> caracs = new LinkedList<Entries>();
        Entries temp= new Entries(' ',0);
        caracs.add(temp);

        boolean recheckFlag=true;

        while(recheckFlag)
        {
            
            for (int i=0;i< s.length();i++){
                
                if (s.charAt(i)==caracs.getLast().charac){
                    if((caracs.getLast().occourances+1)%k!=0)
                        caracs.getLast().occourances=(caracs.getLast().occourances+1)%k;
                    else{
                        caracs.removeLast();
                    }
                }
                else{
                    temp= new Entries(s.charAt(i),1);
                    caracs.add(temp);
                }
            }
            recheckFlag=false;
            
            for (int i = 1; i < caracs.size(); i++) {
                if(caracs.get(i).charac==caracs.get(i-1).charac){
                    if((caracs.get(i).occourances+caracs.get(i-1).occourances)%k==0){
                        caracs.remove(i);
                        caracs.remove(i-1);

                        i=i-2;
                    }
                    else
                    {
                        caracs.get(i-1).occourances=(caracs.get(i).occourances+caracs.get(i-1).occourances)%k;
                        caracs.remove(i);
                        i--;
                    }
                    recheckFlag=true;
                }
            }
            
        }

        String output="";
        for (int i = 1; i < caracs.size(); i++) {
                for (int j=0;j<caracs.get(i).occourances;j++)
                    output=output+caracs.get(i).charac;
        }
        return output;
        
    }
}