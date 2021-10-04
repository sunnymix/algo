package w01.c03stack;

import common.Print;

/**
 * leetcode: https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        Print.line(maximalRectangle(new char[][]{}));
        Print.line(maximalRectangle(new char[][]{{'0'}}));
        Print.line(maximalRectangle(new char[][]{{'1'}}));
        Print.line(maximalRectangle(new char[][]{{'0', '0'}}));
        Print.line(maximalRectangle(new char[][]{
                {'0', '1'},
                {'1', '0'}
        }));
        Print.line(maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length <= 0) return 0;
        int colSize = matrix[0].length;
        int[] heights = new int[colSize];
        int res = 0;
        for (char[] rowCols : matrix) {
            for (int i = 0; i < colSize; i++) {
                int colVal = rowCols[i] == '1' ? 1 : 0;
                // 遇到0，此列的height也要置0
                if (colVal == 0) {
                    heights[i] = 0;
                } else {
                    heights[i] += colVal;
                }
            }
            res = Math.max(res, LargestRectangleInHistogram.largestRectangleArea(heights));
        }
        return res;
    }
}
