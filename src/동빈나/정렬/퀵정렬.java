package 동빈나.정렬;

public class 퀵정렬 {
    static int arr[] = {7, 5, 9, 0, 3, 1, 6, 2,  4, 8};

    public static void main(String[] args) {
        int n = arr.length;
        quickSort(0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int start, int end) {

        if (start >= end)   return;     // 원소가 1개인 경우

        int pivot = start;
        int left = start+1;
        int right = end;

        while (left <= right) {
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && arr[left] <= arr[pivot]) left++;
            // 피벗보다 작 데이터를 찾을 때까지 반복
            while (right > start && arr[right] >= arr[pivot]) right--;

            // 크로스 되었을 경우
            if (left > right) {
                swap(pivot, right);
            }else{
                swap(right, left);
            }
        }
        quickSort(start, right - 1);
        quickSort(right+1, end);
    }

    private static void swap(int pivot, int right) {
        int temp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = temp;
    }

}

