package liveCoding;

import java.util.Stack;

public class makeque {

    Stack<String> inStack;
    Stack<String> outStack;
    makeque(){
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public static void main(String[] args) {
        makeque mq = new makeque();
        System.out.println( mq.deQueue());
        mq.enQueue("30");
        mq.enQueue("20");
        mq.enQueue("60");
        System.out.println( mq.deQueue());
        mq.enQueue("10");
        System.out.println( mq.deQueue());
        mq.enQueue("20");


    }

    private void enQueue(String data){
        inStack.push(data);
    }

    private String deQueue(){
        // queue가 비어있는 경우
        if( inStack.isEmpty() && outStack.isEmpty() ) {
            return "underflow";
        }

        if( outStack.isEmpty() ){
            while( !inStack.empty() ){
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();

    }
}
