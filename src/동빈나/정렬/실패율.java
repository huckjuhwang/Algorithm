package 동빈나.정렬;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 실패율 {

    public static void main(String[] args) {

//        int[] result = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        int[] result = solution(4, new int[]{4,4,4,4,4});

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public static int[] solution(int N, int[] stages) {
        int result[] = new int[N];

        Arrays.sort(stages);

        // 스테이지에 도달한 플레이어의 수
        int stage_human = stages.length;
        List<Node> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    count++;
                }
            }

            // 실패율과 stage를 return
            if (count == 0 || stage_human == 0) {
                list.add(new Node(i, 0));
            }else{
                list.add(new Node(i, (double)count / stage_human));
            }
            stage_human -= count;
        }
        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            result[i] = list.get(i).getStage();
        }

        return result;
    }
}

class Node implements Comparable<Node> {

    private int stage;
    private double fail;

    public Node(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }


    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public double getFail() {
        return fail;
    }

    public void setFail(double fail) {
        this.fail = fail;
    }

    @Override
    public int compareTo(Node other) {
        if (this.fail == other.fail) {
            return Integer.compare(this.stage, other.stage);
        }
        // 내림차순
        return Double.compare(other.fail, this.fail);
    }
}
