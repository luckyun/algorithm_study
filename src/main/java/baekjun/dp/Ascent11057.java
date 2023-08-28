package baekjun.dp;

import java.io.*;

/**
 * 11057 오르막 수
 * https://www.acmicpc.net/problem/11057
 */
public class Ascent11057 {
    static final int MOD = 10007;
    static final int EON =  10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][EON];
        int ans = 0;
        for (int i = 0; i < EON; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < EON; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
            }
        }

        for (int caseNum : dp[n]) {
            ans = (ans + caseNum) % MOD;
        }

        System.out.println(ans);
    }


}
