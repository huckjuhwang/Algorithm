package 동빈나.그리디;


/**
 * 화폐의 종류가 N 이라고 했을 때,
 * 시간복잡도 O(N)
 */
public class 거스름돈 {
    public static int coin[] = {500, 100, 50, 10};
    public static void main(String[] args) {

        int money = 1400;
        int count = 0;

        for (int i = 0; i < coin.length; i++) {
            count += money / coin[i];
            money %= coin[i];
        }

        System.out.println(count);

    }
}
