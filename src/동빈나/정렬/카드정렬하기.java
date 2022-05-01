package 동빈나.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 카드정렬하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        // queue에 1개의 원소가 남을때 까지
        while (pq.size() != 1) {
            int one = pq.poll();
            int two = pq.poll();

            int summary = one + two;
            sum += summary;
            pq.offer(summary);
        }

        System.out.println(sum);
    }
}
