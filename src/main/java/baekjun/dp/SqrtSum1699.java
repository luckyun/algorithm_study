package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1699 제곱수의 합
 * https://www.acmicpc.net/problem/1699
 */
public class SqrtSum1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int fNum = (int) Math.sqrt(n);

        for (int i = 1; i <= n ; i++) {
            dp[i] = i;
        }
        for (int i = 2; i <= fNum ; i++) {
            for (int j = i*i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j-i*i]+1);
            }
        }
        System.out.println(dp[n]);
    }
}
