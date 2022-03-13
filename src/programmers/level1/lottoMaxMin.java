package programmers.level1;

import java.util.Arrays;

public class lottoMaxMin {

    public static void main(String[] args) {
//[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]
        solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int luckyCnt = 0;
        int zeroCnt = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] != 0) {
                for (int j = 0; j < win_nums.length; j++) {
                    if( lottos[i] == win_nums[j] ){
                        luckyCnt++;
                    }
                }
            }else{
                zeroCnt++;
            }
        }
        answer[0] = getRanking(luckyCnt + zeroCnt);
        answer[1] = getRanking(luckyCnt);
        return answer;
    }


    public static int getRanking(int cnt) {
        switch (cnt) {
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default:
                return 6;
        }
    }
}
