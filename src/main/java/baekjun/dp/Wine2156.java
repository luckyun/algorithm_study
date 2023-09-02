package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 포도주 시식 2156
 * https://www.acmicpc.net/problem/2156
 */
public class Wine2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wines[1];
        if(n > 1) {
            dp[2] = dp[1] + wines[2];
        }


        for (int i = 3; i < wines.length; i++) {
            dp[i] = Math.max(Math.max(dp[i-2]+wines[i], dp[i-3]+wines[i-1]+wines[i]), dp[i-1]);
        }

        System.out.println(dp[n]);


    }
}
