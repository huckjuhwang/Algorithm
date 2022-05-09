package backjoon.IM기출대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2116 {

    // 마주보고 있는 면의 idx를 담은 배열
    static int op[] = {5, 3, 4, 1, 2, 0};
    static int arr[][];
    static int max = 0;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][6];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 6; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 6개의 면을 바닥으로 두고 호출한다.
        for (int i = 0; i < 6; i++) {
            dfs(arr[0][op[i]],1, getSideMax(arr[0][op[i]], arr[0][i]));
        }

        System.out.println(max);
    }


    public static void dfs(int top, int diceNum, int sum) {
        // 종료 조건
        if (diceNum == n) {
            max = Math.max(max, sum);
            return;
        }

        int nextBottomIDX = getTopToBottomIDX(top, diceNum);
        int nextBottom = top;
        int nextTopIDX = op[nextBottomIDX];
        int nextTop = arr[diceNum][nextTopIDX];

        dfs(nextTop,diceNum + 1, sum + getSideMax(nextTop, nextBottom));
    }


    public static int getTopToBottomIDX(int bottomIDX, int diceNum) {
        for (int i = 0; i < 6; i++) {
            if (bottomIDX == arr[diceNum][i]) {
                return i;
            }
        }
        return 0;
    }


    /**
     * top, bottom을 제외하고 최대 값을 리턴해준다.
     */
    public static int getSideMax(int top, int bottom) {
        int arr[] = new int[7];
        arr[top]++;
        arr[bottom]++;

        for (int i = 6; i >=0 ; i--)
            if (arr[i] == 0) return i;

        return 0;
    }
}
