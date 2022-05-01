package 동빈나.정렬;

public class 선택정렬 {
    static int arr[] = {7, 5, 9, 0, 3, 1, 6, 2, 7, 4, 8};

    public static void main(String[] args) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min_idx])  min_idx = j;
            }
            swap(i, min_idx);
        }


        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }


    }

    private static void swap(int i, int min_idx) {
        int temp = arr[min_idx];
        arr[min_idx] = arr[i];
        arr[i] = temp;
    }
}
