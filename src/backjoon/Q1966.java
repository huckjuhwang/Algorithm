package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int arr[] = new int[N];
            int idx = N-1;

            Queue<Integer> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                // target Index임을 알기위해 음수값으로 저장
                q.add((target == i) ? -1 * arr[i] : arr[i]);
            }

            Arrays.sort(arr);
            int print = 0;
            boolean check = false;

            while (!q.isEmpty()) {
                // 현 시점 가장높은 중요도를 가지는 값을 가져옴
                int max = arr[idx--];

                // queue를 순회하며, 가장 높은 중요도를 가지는 값을 찾을때 까지 순회
                for (int i = 0; i < q.size(); i++) {
                    int temp = q.poll();

                    // 현 시점 가장 높은 중요도를 가지는 값을 찾았다면,
                    // 출력 횟수 증가++
                    if (Math.abs(temp) == max) {
                        print++;
                        // 만약 target Index이면 체크 후 종료
                        if (temp < 0)  check = true;
                        break;
                    }else{
                        q.add(temp);
                    }
                }

                // 만약 target index의 값이 poll() 되었다면 종료
                if( check ) break;
            }


            System.out.println(print);


        }
    }
}
