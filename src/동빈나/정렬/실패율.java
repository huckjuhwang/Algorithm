package 동빈나.정렬;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 실패율 {

    public static void main(String[] args) {

        int[] result = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
//        int[] result = solution(4, new int[]{4,4,4,4,4});
//
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public static int[] solution(int N, int[] stages) {
        int result[] = new int[N];
        int len = stages.length;
        List<Node> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) {
                    count++;
                }
            }

            if (count == 0 || len == 0) {
                list.add(new Node(i, 0));
            }else{
                list.add( new Node(i, (double) count / len));
            }

            len -= count;
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

    public double getFail() {
        return fail;
    }


    @Override
    public int compareTo(Node other) {
        if (this.getFail() == other.getFail()) {
            // 오름차순
            return Integer.compare(this.getStage(), other.getStage());
        }
        // 내림차순
        return Double.compare(other.getFail(), this.getFail());
    }
}


