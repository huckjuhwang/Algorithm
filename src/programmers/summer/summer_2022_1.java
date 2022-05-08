package programmers.summer;

public class summer_2022_1 {

    public static void main(String[] args) {
        int solution = solution(new int[][]{{80, 35}, {70, 38}, {100, 41}, {75, 30}, {160, 80}, {77, 29}, {181, 68}, {151, 76}});
        System.out.println(solution);
    }


    /**
     * 사용한 마스크의 개수를 리턴
     *  마스크는 D+2일까지 사용
     *  미세먼지, 초미세먼지
     */

    public static int solution(int[][] atmos) {
        // 마스크 사용 일수 체크
        // 3일 까지 사용
        int days = 0;
        int count = 0;

        for (int[] atom : atmos) {
            int dust = atom[0];
            int ulDust = atom[1];

            days = days % 3;
            // 마스크를 쓰기 시작했다면 일수 카운트;
            if (days != 0)     days++;

            // 둘다 매우 나쁠 경우 이날 까지만 사용해야됨.
            if (dust >= 151 && ulDust >= 76) {
                if (days != 0) {
                    days = 0;
                }else {
                    count++;
                }
                continue;
            }
            // 둘중 하나가 나쁨 이상일 경우 마스크 새로 착용 && 아직 사용중이 아닌 경우
            if ((dust >= 81 || ulDust >= 36) && days == 0) {
                days++;
                count++;
            }
        }
        return count;
    }
}