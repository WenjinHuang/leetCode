package RotateString_796;

/*

We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
Note:

A and B will have length at most 100.

Method 1: Brutal force

Method 2: One line code
 */

public class RotateString796 {

    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        
        //Method 1:
        for(int i = 0; i <= A.length(); i++) {
            //System.out.println(A.substring(i, A.length())+A.substring(0, i));
            if((A.substring(i, A.length())+A.substring(0, i)).equals(B)) {
                return true;
            }
        }
        return false;    
    
        //Method 2: one line code
        //return (A+A).contains(B);
    }
}
