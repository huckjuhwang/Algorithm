package 동빈나.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 편집거리 {

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int dp[][] = new int[len1+1][len2+1];

        // 초기화
        for(int i =1; i<=len1; i++)
            dp[i][0] = i;
        for(int i =1; i<=len2; i++)
            dp[0][i] = i;

        // 연산
        for(int i =1; i<=len1; i++){
            for(int j=1; j<len2; j++){
                // 문자가 같을 경우
                if( word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
//        String str1 = sc.next();
//        String str2 = sc.next();
//        // 최소 편집 거리 출력
//        System.out.println(minDistance(str1, str2));


        int[] solution = solution(new int[][]{{1, 4}, {3, 4}, {3, 10}});
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }



    public static int[] solution(int[][] v) {
        int[] answer = {};

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();



        for(int[] var : v){
            if (xMap.get(var[0]) == null)   xMap.put(var[0],1);
            else  xMap.remove(var[0]);

            if (yMap.get(var[1]) == null)   yMap.put(var[1],1);
            else  yMap.remove(var[1]);
        }

        int x = 0;
        int y = 0;
        for (Integer key : xMap.keySet())
            x = key;

        for (Integer key : yMap.keySet())
            y = key;

        return new int[]{x, y};
    }

}
