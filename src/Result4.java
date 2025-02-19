import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Result4 {

    public static List<Integer> getServerIndex(int n, List<Integer> arrival, List<Integer> burstTime) {
        // Write your code here
        Integer[] result = new Integer[arrival.size()];

        PriorityQueue<Request> requests;


        // 각 서버별 점유 풀리는 시간을 관리한다.
        int[] occupy = new int[n+1];

        requests = new PriorityQueue<>((o1, o2) -> o1.arrival - o2.arrival);

        for (int i = 0; i < arrival.size(); i++) {
            requests.offer(new Request(i, burstTime.get(i), arrival.get(i)));
        }

        System.out.println(requests);


        int currentTime = 0;
        int serverNumber = 1;
        while (!requests.isEmpty()) {
            currentTime++;

            // 풀리는거 체크
            for (int i = 0; i < occupy.length; i++) {
                if(occupy[i] == currentTime) {
                    // 풀어줄게 남아있다면
                    if(serverNumber != 1) {
                        serverNumber--;
                        occupy[i] = 0;
                    }
                }
            }

            // 현재 시간에 대한 모든 데이터를 가지고 와야댐
            while (!requests.isEmpty()) {
                Request current = requests.peek();
                // 현재 도착시간serverNumber++이 아닌 경우
                 if(current.arrival != currentTime) {
                    break;
                }

                // 현재 도착시간인 경우 현재 데이터를 뽑아낸다
                requests.poll();

                // 현재 데이터가 점유가 가능한지 확인한다.
                if(n < serverNumber) {
                    result[current.number] = -1;
                    continue;
                }

                // 점유가 가능하다면 점유 실시
                for (int i = 1; i <= n; i++) {
                    if(occupy[i] == 0) {
                        result[current.number] = i;
                        occupy[i] = current.bustTime + current.arrival;
                        break;
                    }
                }

                serverNumber++;
            }
        }

        return List.of(result);
    }


    /**
     * 3
     *
     * 6
     * 18
     * 12
     * 14
     * 10
     * 4
     * 1
     *
     * 6
     * 13
     * 13
     * 12
     * 13
     * 10
     * 6
     * @param args
     */
    public static void main(String[] args) {
        getServerIndex(3, List.of(new Integer[]{6, 18, 12, 14, 10, 4, 1}), List.of(new Integer[]{6, 13, 13, 12, 13, 10, 6}));
    }

    public static class Request {
        int number, bustTime, arrival;

        public Request(int number, int bustTime, int arrival) {
            this.number = number;
            this.bustTime = bustTime;
            this.arrival = arrival;
        }
    }
}
