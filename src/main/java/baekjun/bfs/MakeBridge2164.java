package baekjun.bfs;

import java.io.*;
import java.util.*;

/**
 * 다리 만들기 2146
 * https://www.acmicpc.net/problem/2146
 */
public class MakeBridge2164 {static class Location{
    int x;
    int y;
    int step;

    public Location(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;



    }
}

    static int[][] MATRIX;
    static int[][] MARKING_MATRIX;
    static boolean[][] isVisited ;
    static int N;
    static int[] X = { 0, -1, 0, 1};
    static int[] Y = {-1,  0, 1, 0};

    static int cnt = 0;

    static List<Integer> result = new ArrayList<>();
    static Queue<Location> calQueue = new LinkedList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        //입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        MATRIX = new int[N][N];
        MARKING_MATRIX  = new int[N][N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                MATRIX[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //같은 걸로 만들고
        isVisited = new boolean[N][N];
        int cntIsland = 1;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!isVisited[i][j] && MATRIX[i][j]  == 1) {
                    bfs(new Location(i, j, cntIsland++));
                }
            }
        }

        isVisited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(MATRIX[i][j] > 0) {
                    calQueue.add(new Location(i, j, 0));
                }
            }
        }



        spread(calQueue);
        Collections.sort(result);
        int ans = result.get(0);
        bw.write( ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }



    private static void spread(Queue<Location> q) {

        while(!q.isEmpty()) {
            Location currLoc = q.poll();
            int cX = currLoc.x;
            int cY = currLoc.y;
            int cS = currLoc.step;

            for(int i=0;i<X.length;i++) {
                int nX = cX + X[i];
                int nY = cY + Y[i];

                if(nX>-1 && nY>-1 && nX<N && nY<N) {
                    if(MATRIX[cX][cY] != MATRIX[nX][nY] && MATRIX[nX][nY] != 0) {
                        result.add(MARKING_MATRIX[cX][cY]+MARKING_MATRIX[nX][nY]);
                    }
                    else if(MATRIX[nX][nY] == 0 && !isVisited[nX][nY]) {
                        q.add(new Location(nX, nY, cS+1));
                        MATRIX[nX][nY] = MATRIX[cX][cY];
                        MARKING_MATRIX[nX][nY] = cS+1;
                        isVisited[nX][nY] = true;

                    }

                }
            }
        }
    }







    private static void bfs(Location location) {
        Queue<Location> q = new LinkedList<>();
        q.add(location);
        isVisited[location.x][location.y] = true;
        MATRIX[location.x][location.y] = location.step;
        while(!q.isEmpty()) {
            Location currLoc = q.poll();
            int cX = currLoc.x;
            int cY = currLoc.y;
            int cS = currLoc.step;

            for(int i=0;i<X.length;i++) {
                int nX = cX + X[i];
                int nY = cY + Y[i];

                if(nX>-1 && nY>-1 && nX<N && nY<N) {
                    if(MATRIX[nX][nY] == 1 && !isVisited[nX][nY]) {
                        MATRIX[nX][nY] = cS;
                        isVisited[nX][nY] = true;
                        q.add(new Location(nX, nY, cS));
                    }
                }
            }
        }
    }
}