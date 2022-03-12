package liveCoding;

/**
 * 삽입정렬
 */
public class insertionSort {

    int[] arr = {7, 3, 2, 8, 9, 4, 6, 1, 5};

    public static void main(String[] args) {

        int[] arr = {7, 3, 2, 8, 9, 4, 6, 1, 5};
        int target;

        for (int i = 1; i < arr.length; i++) {
            target = arr[i];
            int j = i - 1;

            while (j>=0 && arr[j] > target){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = target;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[i] = " + arr[i]);
        }
    }


}
