package programmers.pccp;

public class Q1 {

//    	[5, 1, 5], 30, [[2, 10], [9, 15], [10, 5], [11, 5]]
//    [2, 1, 3], 20, [[1, 15], [6, 2]]
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3}, 20, new int[][]{{1, 15}, {6, 2}}));
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int bonus = bandage[2]; // 보너스


        int successCount = 0;
        int nowHealth = health;
        int nowTime = 1;


        for(int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];

            for (; nowTime<=attackTime; nowTime++) {
                if(attackTime == nowTime) {
                    nowHealth = nowHealth - damage;
                    successCount = 0;
                } else {
                    successCount++;

                    if(successCount == t) {
                        nowHealth += bonus;
                        successCount = 0;
                    }

                    nowHealth += x;

                    // 초과 했을 경우 예외 처리
                    if(nowHealth > health) {
                        nowHealth = health;
                    }
                }
                if(nowHealth <= 0) return -1;
            }
        }


        return nowHealth;
    }
}
