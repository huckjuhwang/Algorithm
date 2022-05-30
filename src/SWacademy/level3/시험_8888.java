package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 시험_8888 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int arr[][] = new int[N][T];
            int problemCnt[] = new int[N];  // 각 N명의 푼 문제수
            int sum[] = new int[N];         // 각 N명의 푼 점수결과
            int score[] = new int[T];       // 문제에 대한 점수

            // 입력 및 초기화
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < T; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    // 문제를 풀었다면 ++;
                    if (arr[i][j] == 1) {
                        problemCnt[i]++;
                    }
                }
            }

            // 각 문제에 대한 점수 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    score[j] += arr[i][j];
                }
            }

            // 각 N명의 푼 점수결과
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    // 문제를 풀었다면,
                    if (arr[i][j] == 1) {
                        sum[i] += (N-score[j]);
                    }
                }
            }

            List<human> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new human(i + 1, problemCnt[i], sum[i]));
            }

            Collections.sort(list);

            int grade = 1;
            for (human h : list) {
                // 지학이라면,
                if (h.P == P) {
                    System.out.println("#" + testCase + " " + h.sum + " " + grade);
                    break;
                }
                grade++;
            }

        }
    }
}

class human implements Comparable<human> {
    public int P;               // 입사 시점 번호
    public int problemCnt;      // 문제 수
    public int sum;             // 합계

    public human(int p, int problemCnt, int sum) {
        this.P = p;
        this.problemCnt = problemCnt;
        this.sum = sum;
    }

    // > 1 ( 오름차순 ) < 1 ( 내림차순 )
    @Override
    public int compareTo(human o) {
        // 합계는 큰값 먼저 출력 ( 내림차순 )
        if (this.sum > o.sum) {
            return -1;
        } else if (this.sum < o.sum) {
            return 1;
        }

        // 더많은 문제를 출력
        if (this.problemCnt > o.problemCnt) {
            return -1;
        } else if (this.problemCnt < o.problemCnt) {
            return 1;
        }

        // 등수가 낮은애 부터 정렬
        if (this.P < o.P) {
            return -1;
        } else if (this.P > o.problemCnt) {
            return 1;
        }

        return 1;
    }
}
