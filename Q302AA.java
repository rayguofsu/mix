 302. Smallest Rectangle Enclosing Black Pixels 

An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]

and x = 0, y = 2,

Return 6. 

public class Solution {


    /*If we don't know programming, how do we find the 4 boundaries given a black pixel?

Do we need to search every black cell? Absolutely not.

Intuitively, we would expand from the given 1 * 1 black cell, "aggressively" expand to the 4 boundaries, roughly half of the remaining space. If we don't "cut" any black pixel, we know we go too far and should go back half.

This is exactly the process of binary search.

One simple way without any worry about boundary, is as follows:

    Use a vertical line, to jump to the leftmost black pixel , in the range of [0, y]
    Use a vertical line, to jump to the rightmost black pixel, in the range of [y, n - 1]
    Use a horizontal line, to jump to the topmost black pixel, in the range of [0, x]
    Use a horizontal line, to jump to the bottommost black pixel, in the range of [x, m - 1]

Hope it helps!
*/
public int minArea(char[][] image, int x, int y) {
    int left = leftmost(image, 0, y, true);
    int right = rightmost(image, y, image[0].length - 1, true);
    int top = leftmost(image, 0, x, false);
    int bottom = rightmost(image, x, image.length - 1, false);
    return (right - left + 1) * (bottom - top + 1);
}

int leftmost(char[][] image, int min, int max, boolean horizontal) {
    int l = min, r = max;
    while (l < r) {
        int mid = l + (r - l) / 2;
        if (!hasBlack(image, mid, horizontal)) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    return l;
}

int rightmost(char[][] image, int min, int max, boolean horizontal) {
    int l = min, r = max;
    while (l < r) {
        int mid = l + (r - l + 1) / 2;
        if (!hasBlack(image, mid, horizontal)) {
            r = mid - 1;
        } else {
            l = mid;
        }
    }
    return r;
}

boolean hasBlack(char[][] image, int mid, boolean horizontal) {
    if (horizontal) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][mid] == '1') {
                return true;
            }
        }
    } else {
        for (int j = 0; j < image[0].length; j++) {
            if (image[mid][j] == '1') {
                return true;
            }
        }
    }
    return false;
}
}
