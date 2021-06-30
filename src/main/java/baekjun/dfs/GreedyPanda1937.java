package baekjun.dfs;

import java.io.*;
import java.util.Arrays;

/**
 * 욕심쟁이 판다
 * https://www.acmicpc.net/problem/1937
 */
public class GreedyPanda1937 {


    private static int[][] forest;
    private static int [][]visited;




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int forestLength = Integer.parseInt(br.readLine());
        forest = new int[forestLength][forestLength];
        visited = new int[forestLength][forestLength];

        for (int i = 0; i < forestLength; i++) {
           forest[i] = Arrays.stream(br.readLine().split(" ", forestLength))
           .mapToInt(Integer::parseInt)
           .toArray();
        }
        int maxMove = 0;

        for (int i = 0; i < forestLength; i++) {
            for (int j = 0; j < forestLength; j++) {

                maxMove = Math.max(dfs(i,j), maxMove);
            }

        }
        bw.write(String.valueOf(maxMove));
        bw.flush();

        br.close();
        bw.close();

    }

    private static int dfs(int row, int col) {
        if(visited[row][col] > 0){
            return visited[row][col];
        }
        int[] r = {-1,1,0,0};
        int[] c = {0,0,1,-1};


        int cnt = 1;

        for (int i = 0; i < r.length; i++) {
            int nextRow = row + r[i];
            int nextCol = col + c[i];

            if(nextRow > -1 && nextRow < forest.length && nextCol > -1 && nextCol < forest.length){
                if(forest[row][col] < forest[nextRow][nextCol]){

                    cnt = Math.max( cnt, dfs(nextRow, nextCol)+1);
                    visited[row][col] = cnt;
                }

            }
        }

        return cnt;
        
        
    }
}
