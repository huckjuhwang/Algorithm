package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 시샘이의735게임_5948 {
    
    public static Set<Integer> rank5;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int size = 7;

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            rank5 = new HashSet<>();
            int arr[] = new int[size];
            
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(st.nextToken());    
            }

            dfs(arr, 0, 0, 0);

            List rank5List = new ArrayList(rank5);
            Collections.sort(rank5List, Collections.reverseOrder());

            int idx = 0;
            for (Object num : rank5List) {
                // 5번째 숫자 출력
                if (idx == 4) {
                    System.out.println("#" + testCase + " " + num);
                }
                idx++;
            }

            
        }
    }

    public static void dfs(int arr[], int sum, int cnt, int start) {
        if (cnt == 3) {
            rank5.add(sum);
            return;
        }

        cnt += 1;
        for (int i = start; i < arr.length; i++) {
            dfs(arr, sum+arr[i], cnt, ++start);
        }
    }
}
