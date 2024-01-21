package backjoon.segmentTree;

import java.util.Scanner;

public class example {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int K = scan.nextInt();

        long arr[] = new long[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = scan.nextLong();
        }

        SegmentTree tree = new SegmentTree(N);
        tree.init(arr, 1, 1, N);

        for (int i=0; i< M+K; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            long c = scan.nextLong();

            // b번째 수를 C로 변환하라
            if(a == 1) {
//                int node, int start, int end, int idx, long diff
                tree.update(1, 1, N, b, c-arr[b]);
                arr[b] = c;
            } else {
            // B~C까지 더해라
                long sum = tree.sum(1, 1, N, b, (int) c);
                System.out.println(sum);
            }
        }
    }



    static class SegmentTree {
        long tree[];
        int treeSize;


        public SegmentTree(int arrSize) {
            // 트리 높이 구하기
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int)Math.pow(2, h+1);

            tree = new long[treeSize];
        }


        public long init(long[] arr, int node, int start, int end) {
            // leaf node check
            if(start == end) {
                return tree[node] = arr[start];
            }

            // not leaf node
            return tree[node] = init(arr, node*2, start, (start+end)/2) +
                    init(arr, node*2+1, (start+end)/2+1, end);
        }


        // idx: 변경된 데이터의 idx, diff: 원래 데이터 값과 변경 데이터값의 차이
        public void update(int node, int start, int end, int changeIdx, long diff) {
            // 만약 변경할 index 값이 범위 밖인지 체크
            if(changeIdx < start || changeIdx > end) {
                return;
            }

            // 차를 저장
            tree[node] += diff;

            // 리프노드가 아니면 하위 자식들도 확인
            if(start != end) {
                update(node*2, start, (start+end)/2, changeIdx, diff);
                update(node*2+1, (start+end)/2+1, end, changeIdx, diff);
            }
        }


        public long sum(int node, int start, int end, int left, int right){
            if(left > end || right < start) {
                return 0;
            }

            if(left <= start && end <= right) {
                return tree[node];
            }

            return sum(node*2, start, (start+end)/2, left, right) +
                    sum(node*2+1, (start+end)/2+1, end, left, right);
        }
    }
}
