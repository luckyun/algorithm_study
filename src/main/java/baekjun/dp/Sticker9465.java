package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * 9465 스티커
 * https://www.acmicpc.net/problem/9465
 */
public class Sticker9465 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int startCaseNum = 0;
        int endCaseNum = Integer.parseInt(br.readLine());



        while (startCaseNum < endCaseNum) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n];
            int[][] stickerArr = new int[2][n];

            stickerArr[0] =  Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            stickerArr[1] =  Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


            dp[0][0] = stickerArr[0][0];
            dp[1][0] = stickerArr[1][0];



            if(n > 1) {

                dp[0][1] = dp[1][0] + stickerArr[0][1];
                dp[1][1] = dp[0][0] + stickerArr[1][1];

                for (int i = 2; i < n; i++) {
                    dp[0][i] = Math.max(dp[1][i-1] + stickerArr[0][i], stickerArr[0][i]+dp[1][i-2]);
                    dp[1][i] = Math.max(dp[0][i-1] + stickerArr[1][i], stickerArr[1][i]+dp[0][i-2]);
                }

            }


            startCaseNum++;
            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }


    }


}
