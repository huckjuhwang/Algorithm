package backjoon;

import java.io.*;
import java.util.*;

public class Q2188 {
    static List<Integer> list[];
    static int dp[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        dp = new int[m + 1];    // 현재 축사에 몇번째 소가 들어가 있는지
        visit = new boolean[m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            for (int j = 0; j < s; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            Arrays.fill(visit, false);
            if( dfs(i)) count++;
        }
        System.out.println(count);


    }


    public static boolean dfs(int here) {
        for (int num : list[here]) {
            if (!visit[num]) {
                visit[num] = true;
                if (dp[num] == 0 || dfs(dp[num])) {
                    dp[num] = here;
                    return true;
                }
            }
        }
        return false;
    }
}
