package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 11053 가장 긴 증가하는 부분 수열
 * https://www.acmicpc.net/problem/11053
 */
public class LongestIncSequence11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int curNum = arr[i];

            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[j]+1 > dp[i] ) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }

        }
        int result = 0;
        for (int i : dp) {
            result = Math.max(result, i);
        }
        System.out.println(result);

    }
}
