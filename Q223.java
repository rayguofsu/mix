//Find the total area covered by two rectilinear rectangles in a 2D plane.
//
//Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//Rectangle Area
//
//Assume that the total area is never beyond the maximum possible value of int.

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {














        int sqOne = (C - A) * (D - B);
        int sqTwo = (G - E) * (H - F);
        //this is for non overlapping case
        if (C < E || G < A) return sqOne + sqTwo;
        if (F > D || B > H) return sqOne + sqTwo;
        
        //if there is overlapping
       //         E _________  G
        // A_____________C             you can draw this for vertically
        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        
        //return sq1 + sq2 - overlapping
        
        return sqOne + sqTwo - (right -left) * (top - bottom);
        
        
        
    }
}
