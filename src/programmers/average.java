package programmers;

public class average {
    public double solution(int[] arr) {
        double answer = 0;
        int cnt = 0;
        for( int num : arr ){
            answer+= num;
            cnt ++;
        }
        return answer/cnt;
    }
}
