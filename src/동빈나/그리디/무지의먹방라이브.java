package 동빈나.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 프로그래머스
 * https://programmers.co.kr/learn/courses/30/lessons/42891
 *
 * 무지의 먹방라이브
 */
public class 무지의먹방라이브 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public int solution(int[] food_times, long k) {
        long summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        // 음식을 다먹고 난 다음 정전일 일어났을 경우;
        if (summary <= k)    return -1;

        // 음식을 먹을 수 있는 시간 순서대로 꺼내며, index를 가지고 있어야함, 추후 출력을 위함
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        summary = 0;
        long preTime = 0;
        long length = food_times.length;

        // 핵심로직
        // 현재까지 사용한 시간 + ( (현재시간-이전시간)*len ) <= 정전된 시간
        // false일 경우, 정전 된 이후
        while (summary + (pq.peek().getTime() - preTime) * length <= k) {
            int nowTime = pq.poll().getTime();
            summary += (nowTime-preTime) * length; // 최소 시간을 전체 대상으로 연산
            length-=1;              // 다먹은 음식 제외
            preTime = nowTime;      // 이전시간 음식 시간재설정
        }

        // 정렬을 위한 로직
        ArrayList<Food> food_life = new ArrayList<>();
        while (!pq.isEmpty()) {
            food_life.add(pq.poll());
        }
        Collections.sort(food_life, new Comparator<Food>() {
            @Override
            public int compare(Food food1, Food food2) {
                return Integer.compare(food1.getIdx(), food2.getIdx());
            }
        });

        return food_life.get((int)((k-summary)%length)).getIdx();
    }
}


class Food implements Comparable<Food> {
    private int time;
    private int idx;

    public Food(int time, int idx) {
        this.time = time;
        this.idx = idx;
    }

    public int getTime() {
        return time;
    }

    public int getIdx() {
        return idx;
    }

    @Override
    public int compareTo(Food food) {
        return Integer.compare(this.time, food.time);
    }
}


