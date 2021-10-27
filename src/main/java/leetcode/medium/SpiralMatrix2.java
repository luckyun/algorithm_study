package leetcode.medium;

import java.util.Arrays;

/**
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrix2 {

    public static void main(String[] args) {
        SpiralMatrix2 sp = new SpiralMatrix2();
        int[][] results = sp.generateMatrix(3);

        for (int[] result : results) {
            for (int i : result) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] results = new int[n][n];

        int[] width = {1, 0, -1,  0};
        int[] height ={0, 1,  0, -1};

        MoveObject mo = new MoveObject(0, 0, 1, 0);

        for (int[] result : results) {
            Arrays.fill(result, 0);
        }

        results[0][0] = mo.cnt;
        mo.cnt++;

        while ( mo.cnt <= n*n){
            int nextW = mo.w + width[mo.direction%4];
            int nextH = mo.h + height[mo.direction%4];

            if(nextH > -1 && nextH < n && nextW > -1 && nextW < n && results[nextH][nextW] == 0){
                results[nextH][nextW] = mo.cnt;
                mo.w = nextW;
                mo.h = nextH;
                mo.cnt++;
            } else {
                mo.direction++;
            }
        }

        return results;
    }

    class MoveObject{
        int w;
        int h;
        int cnt;
        int direction;

        public MoveObject(int w, int h, int cnt, int direction) {
            this.w = w;
            this.h = h;
            this.cnt = cnt;
            this.direction = direction;
        }
    }
}
