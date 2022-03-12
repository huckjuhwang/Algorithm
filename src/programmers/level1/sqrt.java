package programmers.level1;

public class sqrt {

    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        return sqrt % 1==0 ? (long)((sqrt+1) * (sqrt+1)) : -1;
    }
}
