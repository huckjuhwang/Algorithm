package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 진용이네주차타워_9280 {
    static Queue<Integer> inOut;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());   // 주차장 개수
            int m = Integer.parseInt(st.nextToken());   // 차량 개수

            int Ci[] = new int[n];  // 주차장 요금 = ci[i] * wi[j]
            int Wi[] = new int[m];  // 차량의 무게

            Car carSet[] = new Car[n];
            int money = 0;


            // 요금을 입력받음
            for (int i = 0; i < n; i++) {
                Ci[i] = Integer.parseInt(br.readLine());
                carSet[i] = new Car(-1, -1);
            }
            // 차량의 무게를 입력받음
            for (int i = 0; i < m; i++)
                Wi[i] = Integer.parseInt(br.readLine());

            // 모든 차량의 순서에 대해서 queue에 삽입
            // 양수일 경우 들어오는 차량/ 음수는 나가는 차량
            inOut = new LinkedList<>();
            for (int x = 0; x < m * 2; x++) {
                int car = Integer.parseInt(br.readLine());

                String state = (car < 0) ? "OUT" : "IN";
                car = Math.abs(car);

                // 들어오고 나가는 차량에 대한 액션이 다름
                if (state.equals("IN")) {
                    parkingCar(n, Wi, carSet, car);

                } else if (state.equals("OUT")) {
                    for (int i = 0; i < n; i++) {
                        if (carSet[i].carNum == car) {
                            money += carSet[i].weight * Ci[i];
                            carSet[i].weight = -1;  // 빈자리로 변경

                            // 대기하는 차량이 있을경우 파킹
                            if (!inOut.isEmpty()) {
                                int waitCar = inOut.poll();
                                parkingCar(n, Wi, carSet, waitCar);
                            }
                            break;
                        }
                    }
                }

            }


            System.out.println("#" + testCase + " " + money);



        }
    }

    private static void parkingCar(int n, int[] Wi, Car[] carSet, int car) {
        for (int i = 0; i < n; i++) {
            // 지금 현재 자리가 비어 있다면 (가장 빠른 번호에 세팅)
            if (carSet[i].weight == -1) {
                carSet[i].carNum = car;
                carSet[i].weight = Wi[car -1];
                break;
            }

            // 마지막까지 넣을 공간이 없을 경우
            if (i == n - 1) {
                // 다 꽉차있는 상태이기 때문에 큐에 삽입
                inOut.add(car);
            }
        }
    }
}

class Car{
    public int carNum;
    public int weight;

    public Car(int carNum, int weight) {
        this.carNum = carNum;
        this.weight = weight;
    }
}
