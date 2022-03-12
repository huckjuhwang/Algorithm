package liveCoding;

public class quickSort {

    static int[] arr;

    public static void main(String[] args) {

        quickSort qs = new quickSort();
          arr = new int[]{20, 70, 50, 10, 30, 40};
//        arr = {20, 70, 50, 10, 30, 40};
        qs.quickSort(0, arr.length-1);


        for (int n : arr) {
            System.out.println("n = " + n);
        }
    }


    public static void quickSort(int l, int r){
        if( l < r ){
            int p = partition(l, r);

            quickSort(l, p-1);
            quickSort(p + 1, r);
        }

    }

    public static int partition(int l, int r){
        // 가장 오른쪽 값을 pivot
        int pivot = arr[r];
        // pivot보다 작은 개수
        int i = l-1;

        // pivot을 기준으로 정렬 ( pivot 제외 )
        for (int j = l; j <= r-1 ; j++) {
            if ( arr[j] <= pivot ){
                i++;
                swap(i, j);
            }
        }
        // pivot 위치와 i+1의 위치를 변경
        swap(i+1, r);
        return i+1;
    }


    private static void swap(int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


}
