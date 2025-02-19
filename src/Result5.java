import java.util.Arrays;
import java.util.List;

import java.util.Arrays;
public class Result5 {


    /*
     * Complete the 'teamFormation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY score
     *  2. INTEGER team_size
     *  3. INTEGER k
     */
    public static long teamFormation(List<Integer> score, int team_size, int k) {
        // Write your code here


        return 1;
    }

}

class Heap {

    private int[] queue;

    public Heap(int[] arr) {
        this.queue = new int[arr.length + 1];
        this.queue[0] = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            this.queue[i + 1] = arr[i];
        }
        for (int i = this.queue.length / 2; i >= 1; i--) {
            maxHeapify(i);
        }
    }

    private void maxHeapify(int i) {
        int largest = i;
        int left = i * 2;
        int right = i * 2 + 1;

        if (left <= this.queue.length - 1 && this.queue[largest] < this.queue[left]) {
            largest = left;
        }
        if (right <= this.queue.length - 1 && this.queue[largest] < this.queue[right]) {
            largest = right;
        }
        if (largest != i) {
            int temp = this.queue[i];
            this.queue[i] = this.queue[largest];
            this.queue[largest] = temp;
            maxHeapify(largest);
        }
    }

    public void printAll() {
        System.out.print("After heapify: ");
        System.out.print(Arrays.toString(Arrays.copyOfRange(this.queue, 1, this.queue.length)));
        System.out.println(" / 최댓값: " + this.queue[1]);
    }

    public static void main(String[] args) {
        int[] tmp = {6, 18, 8};
        System.out.println("Manager가 선택한 그룹1 : " + Arrays.toString(tmp));
        Heap heap1 = new Heap(tmp);
        heap1.printAll();

        int[] tmp2 = {12, 18, 9};
        System.out.println("Manager가 선택한 그룹2 : " + Arrays.toString(tmp2));
        Heap heap2 = new Heap(tmp2);
        heap2.printAll();
    }
}


