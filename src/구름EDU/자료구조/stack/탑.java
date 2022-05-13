package 구름EDU.자료구조.stack;

import java.io.*;
import java.lang.*;
import java.util.*;

public class 탑 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tower towers[] = new Tower[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 초기화
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            towers[i-1] = new Tower(height, i);
        }


        // 비지니스 로직
        Stack<Tower> stack = new Stack<>();
        for (Tower t : towers) {
            Tower target = null;

            // 현재 값이 더 크다면, 현재값이 작아질때 까지 반복
            while (stack.size() > 0 && stack.peek().height < t.height) {
                stack.pop();
            }

            // 해당 위치는 현재값보다, 다음값이 무조건 큼.
            // 하나 꺼내서 target으로 설정
            if (stack.size() > 0)   target = stack.peek();

            t.setTargetTower(target);
            stack.push(t);
        }

        StringBuilder sb = new StringBuilder();

        for (Tower t : towers) {
            if (t.getTargetTower() == null) {
                sb.append(0 + " ");
            }else {
                sb.append(t.getTargetTower().index + " ");
            }
        }

        System.out.println(sb);



    }
}


class Tower {
    // 높이
    public int height;
    // 위치
    public int index;
    // 목표 타워
    public Tower TargetTower;

    public Tower(int height, int index) {
        this.height = height;
        this.index = index;
        this.TargetTower = null;
    }

    public Tower getTargetTower() {
        return TargetTower;
    }

    public void setTargetTower(Tower targetTower) {
        TargetTower = targetTower;
    }
}