package programmers.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class targetNumber {
    int answer; // 출력 값 ( 횟수 )

    /**
     * dfs 정보를 담을 클래스
     * sum : 합계
     * cur : 노드 방문 횟수
     */
    class dfsObject {
        int sum;
        int cur;

        public dfsObject(int sum, int cur){
            this.sum = sum;
            this.cur = cur;
        }
    }

    public static void main(String[] args) {
        targetNumber tn = new targetNumber();
        int ans = tn.solution(new int[]{4,1,2,1}, 4);

        System.out.println(ans);
    }

    public int solution(int[] numbers, int target) {
        bfs(numbers, target);
        return answer;
    }

    public void bfs(int numbers[], int target){
        dfsObject dfsObj;
        Queue<dfsObject> queue = getQueueInit(numbers[0]);

        while (!queue.isEmpty()){
            dfsObj = queue.poll();
            if ( dfsObj.cur == numbers.length-1 ){
                equalsGoal(target, dfsObj);
            }else {
                queue.offer(new dfsObject(dfsObj.sum + numbers[dfsObj.cur+1], dfsObj.cur+1 ));
                queue.offer(new dfsObject(dfsObj.sum - numbers[dfsObj.cur+1], dfsObj.cur+1 ));
            }
        }
    }

    /**
     * 현재 값이 목표 값과 일치하는지 분석
     */
    private void equalsGoal(int target, dfsObject dfsObj) {
        if( dfsObj.sum == target){
            answer++;
        }
    }

    /**
     * queue 초기세팅
     */
    private Queue<dfsObject> getQueueInit(int number) {
        Queue<dfsObject> queue = new LinkedList<>();
        queue.offer(new dfsObject(number,0));
        queue.offer(new dfsObject(number *-1,0));
        return queue;
    }
}
