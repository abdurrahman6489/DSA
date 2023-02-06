/*
 The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.
Given a string s that represents a DNA sequence, return all the 10-letter long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order. This is a functional problem you have to complete the solve function.
Input
The first line of the input contains the string s.

Constraints
1 <= s. length() <= 1e5
s[i] is either 'A', 'C', 'G', or 'T'
Output
Complete the function and return the relevant strings.
Example
Sample Input:-
GGGGGGGGGGGGG

Sample Output:-
GGGGGGGGGG
 */
package SlidingWindow;

import java.util.*;

class dna_sequence{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            int n = s.length();
            int i; String sub; int x;
            TreeMap<String,Integer> freq = new TreeMap<>();
            for(i=0;i<n-9;i++){
                sub = s.substring(i,i+10);
                //System.out.println(sub);
                freq.put(sub,freq.getOrDefault(sub,0)+1);
            }
            for(Map.Entry<String,Integer> entry: freq.entrySet()){
                sub = entry.getKey();
                x = entry.getValue();
                if(x>1){
                    System.out.println(sub);
                }
            }

        }
    }
}