package liveCoding;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class targetNumber {

    static int answer;
    static boolean visited[];

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println("solution = " + solution);

    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public static void dfs(int[] numbers, int target, int sum, int depth){

        if( depth==numbers.length  ){
            if( sum == target )
            answer++;
            return;
        }else{
            dfs(numbers, target, (sum + (numbers[depth])), depth+1);
            dfs(numbers, target, (sum + (numbers[depth]*-1)), depth+1);
        }

    }

}
