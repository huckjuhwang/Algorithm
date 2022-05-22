package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 진용이네주차타워_9280 {
    static HashMap<Integer, Integer> Wi, Ci;             // 차량의 무게, 주차장 요금
    static int nowParking[];                            // 주차장 주차 여부(차량번호, 무게)
    static int n, m;                                     // 주차장 개수, 차량 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            Ci = new HashMap<>();
            Wi = new HashMap<>();
            nowParking = new int[m+1];
            int money = 0;

            for (int i = 0; i < n; i++) {
                Ci.put(i + 1, Integer.parseInt(br.readLine()));
            }
            for (int i = 0; i < m; i++) {
                Wi.put(i + 1, Integer.parseInt(br.readLine()));
            }


            Queue<Integer> waitQueue = new LinkedList<>();
            PriorityQueue<Integer> emptySpace = new PriorityQueue();
            for (int i = 0; i < n; i++) {
                emptySpace.add(i + 1);
            }

            for (int x = 0; x < m * 2; x++) {
                int car = Integer.parseInt(br.readLine());
                String state = (car < 0) ? "OUT" : "IN";
                car = Math.abs(car);

                if (state.equals("IN")) {
                    // 현재 자리가 없을 경우
                    if (emptySpace.isEmpty()) {
                        waitQueue.add(car);
                    }else{
                        int parkingIDX = emptySpace.poll();
                        // car번 차량이 IDX위치에 배치된다.
                        nowParking[car] = parkingIDX;
                    }

                } else if (state.equals("OUT")) {
                    money += Wi.get(car) * Ci.get(nowParking[car]);
                    emptySpace.add(nowParking[car]); // 빈자리로 변경

                    // 차량이 나간 후 대기하는 차량이 있을경우 파킹
                    if (!waitQueue.isEmpty()){
                        int waitCar = waitQueue.poll();
                        int parkingIDX = emptySpace.poll();
                        // car번 차량이 IDX위치에 배치된다.
                        nowParking[waitCar] = parkingIDX;
                    };
                }
            }
            System.out.println("#" + testCase + " " + money);
        }
    }
}

