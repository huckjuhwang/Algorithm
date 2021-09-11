package liveCoding;


/**
 * 소수 구하기!!
 *
 * 소수판별 -> 결국 자기자신과 1을 제외한 다른 자연수를 약수로 갖고있으면 안된다는 의미
 *
 *  80의 약수가 1,2,4,5,8,10,16,20,40,80
 *
 *  1*80, 2*40, 4*20, 5*16, 8*10
 *
 *  p*q=N일때, p나 q중 루트N 보다 작은 수가 존재한다.
 *
 *  즉, 루트N 까지만 루프를 돌리면 된다.
 */
public class isPrimeNumber {

    public static void main(String[] args) {
        System.out.println( isPrimeNumber.process(100) );
    }

    public static boolean process(int num){

        for (int i = 2; i*i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
