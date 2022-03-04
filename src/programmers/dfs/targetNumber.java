package programmers.dfs;

public class targetNumber {
    int answer; // 출력 값 ( 횟수 )
    int goal;   // 목표 값

    public targetNumber(){
        answer = 0;
        goal = 0;
    }

    public static void main(String[] args) {
        targetNumber tn = new targetNumber();
        int ans = tn.solution(new int[]{4,1,2,1}, 4);

        System.out.println(ans);
    }

    public int solution(int[] numbers, int target) {
        goal = target;
        dfs(numbers, 0);

        return answer;
    }

    private void dfs(int[] numbers, int node){
        if( numbers.length == node ){
            int sum = getSum(numbers);
            equalsGoal(sum);
        }else {
            dfs(numbers , node+1);
            numbers[node] *= -1;
            dfs(numbers, node+1);
        }
    }

    /**
     *  인자로 넘겨받은 배열의 총합
     */
    private int getSum(int[] numbers) {
        int sum = 0;
        for( int num : numbers) {
            sum += num;
        }
        return sum;
    }

    /**
     * 목표하는 값과 합계 값이 같은지 비교
     */
    private void equalsGoal(int sum) {
        if( goal == sum){
            answer++;
        }
    }

}
