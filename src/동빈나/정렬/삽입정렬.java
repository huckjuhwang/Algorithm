package 동빈나.정렬;

public class 삽입정렬 {
    static int arr[] = {7, 5, 9, 0, 3, 1, 6, 2, 7, 4, 8};

    public static void main(String[] args) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j-1] > arr[j]) {
                    swap(j);
                }else{
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void swap(int j) {
        int temp = arr[j - 1];
        arr[j - 1] = arr[j];
        arr[j] = temp;
    }
}
