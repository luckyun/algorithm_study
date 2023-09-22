package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9461파도반 수열
 * https://www.acmicpc.net/problem/9461
 */
public class PadovanSequence9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(br.readLine());
            long[] dp = new long[101];
            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = dp[5] = 2;

            for (int j = 6; j <= p ; j++) {
                dp[j] = dp[j-1] + dp[j-5];
            }
            sb.append(dp[p]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
