package 동빈나.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 편집거리 {

    // 최소 편집 거리(Edit Distance) 계산을 위한 다이나믹 프로그래밍
    static int editDist(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        int d[][] = new int[len1 + 1][len2 + 1];

        // 초기화
        for (int i = 1; i <= len1; i++)
            d[i][0] = i;
        for (int i = 1; i <= len2; i++)
            d[0][i] = i;

        // 연산
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    d[i][j] = d[i - 1][j - 1];
                }else{
                    d[i][j] = 1 + Math.min(d[i - 1][j], Math.min(d[i][j - 1], d[i - 1][j - 1]));
                }
            }
        }

        // 결과 리턴
        return d[len1][len2];
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        // 최소 편집 거리 출력
        System.out.println(editDist(str1, str2));
    }
}
