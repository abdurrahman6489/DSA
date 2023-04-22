/*
 Given a 2d matrix of size M*N, print the zig traversal of the matrix as shown:-

Consider a matrix of size 5*4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
17 18 19 20

ZigZag traversal:-

1
5 2
9 6 3
13 10 7 4
17 14 11 8
18 15 12
19 16
20
Input
First line of input contains two integers M and N. Next M lines contains N space- separated integers each.

Constraints:-
1 <= M, N <= 100
1 <= Matrix[i][j] <= 100000
Output
Print the zig- zag traversal of the matrix as shown.
ai_logoAI CODELENS
BETA
Simpler Explanation
Concepts Used
Example
Sample Input:-
4 3
1 2 3
4 5 6
7 8 9
10 11 12

Sample Output:-
1
4 2
7 5 3
10 8 6
11 9
12
 */

import java.util.*;

public class matrixZigZagTraversal {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int columns = in.nextInt();
        int[][] matrix = new int[rows][columns];
        int i, j;
        // taking input matrix
        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int currentRow = rows - 1;
        int currentColumn = 0;
        // from 1st row to last row
        for (i = 0; i < rows; i++) {
            for (j = i; j >= 0 && currentColumn < columns; j--) {
                System.out.print(matrix[j][currentColumn++] + " ");
            }
            currentColumn = 0;
            System.out.println();
        }
        // from 1st column last row to last column
        for (j = 1; j < columns; j++) {
            for (currentColumn = j; currentColumn < columns && currentRow >= 0; currentColumn++) {
                System.out.print(matrix[currentRow--][currentColumn] + " ");
            }
            currentRow = rows - 1;
            System.out.println();
        }
    }
}
