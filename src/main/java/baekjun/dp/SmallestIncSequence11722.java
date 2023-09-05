package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11722 가장 긴 감소하는 부분 수열
 * https://www.acmicpc.net/problem/11722
 */
public class SmallestIncSequence11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0 ; j < i ; j++) {
                if(arr[j] > arr[i] && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j]+1;
                }

            }

        }
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        System.out.println(ans);
    }
}
