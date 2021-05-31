import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Solution {
    public int maxArea(int[] height) {
        int ptr1 = 0;
        int ptr2 = height.length - 1;
        int area = 0;

        while (ptr1 < ptr2) {
            int minHeight = Math.min(height[ptr1], height[ptr2]);
            area = Math.max(area, minHeight * (ptr2 - ptr1));

            if (height[ptr1] < height[ptr2]) {
                ptr1 += 1;
            } else if (height[ptr1] > height[ptr2]) {
                ptr2 -= 1;
            } else {
                ptr1 += 1;
                ptr2 -= 1;
            }
        }

        return area;
    }
}
