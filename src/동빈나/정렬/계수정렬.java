package 동빈나.정렬;

public class 계수정렬 {

    public static int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};

    public static void main(String[] args) {

        int n = arr.length;
        int count[] = new int[10];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
