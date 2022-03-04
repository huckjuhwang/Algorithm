package liveCoding;

import java.util.Stack;

/**
 * 두개의 스택으로 한개의 큐 구하기!!
 */
public class makeQueueWithStack2 {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public makeQueueWithStack2() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * 값을 넣어주는 메서드
     */
    public void enQueue(int value){
        inStack.push(value);
    }

    /**
     * 값을 빼주는 메서드
     */
    public Integer deQueue(){
        if (outStack.empty()) {
            while (!inStack.empty()){          // stack이 비어있으면 나감
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public static void main(String[] args) {
        int input[] = {1, 2, 3, 4, 5};
        makeQueueWithStack2 qs = new makeQueueWithStack2();

       qs.enQueue(1);

        qs.enQueue(2);
        System.out.println("qs.deQueue() = " + qs.deQueue());
        qs.enQueue(3);
        System.out.println("qs.deQueue() = " + qs.deQueue());

        System.out.println("qs.deQueue() = " + qs.deQueue());
        qs.enQueue(4);
        qs.enQueue(5);

        System.out.println("qs.deQueue() = " + qs.deQueue());

        System.out.println("qs.deQueue() = " + qs.deQueue());
    }

}
