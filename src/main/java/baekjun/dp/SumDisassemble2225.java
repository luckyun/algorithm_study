package baekjun.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2225 합분해
 * https://www.acmicpc.net/problem/2225
 */
public class SumDisassemble2225 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ans = new int[n+1];

        Arrays.fill(ans, 1);

        for (int j = 2; j < m+1; j++) {
            for (int i = 1; i < n+1; i++) {
                ans[i] = (ans[i-1] + ans[i])%1000000000;
            }
        }
        
        System.out.println(ans[n]);


    }
}
