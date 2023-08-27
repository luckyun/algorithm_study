package baekjun.dp;

import java.io.*;

/**
 * 2×n 타일링 2
 * https://www.acmicpc.net/problem/11727
 */
public class Nx2Tiling11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] ans = new int[n+2];

        ans[1] = 1;
        ans[2] = 3;
        //1,3,5,12

        if(n>2){
            for (int i = 3; i <= n; i++) {
                ans[i] = ans[i-1] + ans[i-2]*2;
                ans[i] = ans[i] % 10007;
            }
        }


        bw.write(ans[n]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
