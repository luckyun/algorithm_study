package baekjun.dp;

import java.io.*;

/**
 * 10844 쉬운 계단수
 * https://www.acmicpc.net/problem/10844
 */
public class EasyStairCount10844 {

    static final int mod = 1000000000;
    static final int len = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][len];

        int ans = 0;

        for (int i = 1; i < len; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i-1][1]) % mod;
            dp[i][9] = (dp[i-1][8]) % mod;
            for (int j = 1; j < len-1; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }

        }

        for (int i = 0; i < len; i++) {
            ans = (ans + dp[n][i]) % mod;
        }
        System.out.println(ans % mod);

    }

}
