package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 무한한 수의 스택이 일렬로 배열되어 있으며, 왼쪽에서 오른쪽으로 0부터 번호가 매겨져 있습니다. 각 스택은 동일한 최대 용량을 가집니다.

 DinnerPlates 클래스를 구현하세요:

 DinnerPlates(int capacity) 객체를 스택의 최대 용량 capacity로 초기화합니다.
 void push(int val) 주어진 정수 val을 용량이 capacity보다 작은 가장 왼쪽 스택에 밀어 넣습니다.
 int pop() 가장 오른쪽에 있는 비어 있지 않은 스택의 맨 위 값을 반환하고 해당 스택에서 제거합니다. 모든 스택이 비어 있으면 -1을 반환합니다.
 int popAtStack(int index) 지정된 인덱스 index를 가진 스택의 맨 위 값을 반환하고 해당 스택에서 제거합니다. 지정된 인덱스의 스택이 비어 있으면 -1을 반환합니다.

 Example 1:

 Input
 ["DinnerPlates", "push", "push", "push", "push", "push", "popAtStack", "push", "push", "popAtStack", "popAtStack", "pop", "pop", "pop", "pop", "pop"]
 [[2], [1], [2], [3], [4], [5], [0], [20], [21], [0], [2], [], [], [], [], []]
 Output
 [null, null, null, null, null, null, 2, null, null, 20, 21, 5, 4, 3, 1, -1]

 Explanation:
 DinnerPlates D = DinnerPlates(2);  // Initialize with capacity = 2
 D.push(1);
 D.push(2);
 D.push(3);
 D.push(4);
 D.push(5);         // The stacks are now:  2  4
 1  3  5
 ﹈ ﹈ ﹈
 D.popAtStack(0);   // Returns 2.  The stacks are now:     4
 1  3  5
 ﹈ ﹈ ﹈
 D.push(20);        // The stacks are now: 20  4
 1  3  5
 ﹈ ﹈ ﹈
 D.push(21);        // The stacks are now: 20  4 21
 1  3  5
 ﹈ ﹈ ﹈
 D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
 1  3  5
 ﹈ ﹈ ﹈
 D.popAtStack(2);   // Returns 21.  The stacks are now:     4
 1  3  5
 ﹈ ﹈ ﹈
 D.pop()            // Returns 5.  The stacks are now:      4
 1  3
 ﹈ ﹈
 D.pop()            // Returns 4.  The stacks are now:   1  3
 ﹈ ﹈
 D.pop()            // Returns 3.  The stacks are now:   1
 ﹈
 D.pop()            // Returns 1.  There are no stacks.
 D.pop()            // Returns -1.  There are still no stacks.


 Constraints:

 1 <= capacity <= 2 * 104
 1 <= val <= 2 * 104
 0 <= index <= 105
 At most 2 * 105 calls will be made to push, pop, and popAtStack.
 */
public class Q1172 extends QBase{

    public static void main(String[] args){
        DinnerPlates D = new Q1172().new DinnerPlates(2);
//        D.push(1);
//        D.push(2);
//        D.push(3);
//        D.push(4);
//        D.push(5);
//
//        D.printStack();
//
//        D.popAtStack(0);
//        D.printStack();
//
//        D.push(20);
//        D.printStack();
//
//        D.push(21);
//        D.printStack();
//
//        D.popAtStack(0);
//        D.printStack();
//
//        D.popAtStack(2);
//        D.printStack();
//
//        D.pop();
//        D.pop();
//        D.pop();
//        D.pop();
//        D.pop();


        // test 2
        var cmds = new String[]{"push", "push", "push", "push", "push", "push",
                "push", "push", "push", "push", "push",
                "push", "push", "push", "push", "push",
                "push", "push", "push", "push",
                "popAtStack", "popAtStack", "popAtStack", "popAtStack", "popAtStack",
                "popAtStack", "popAtStack", "popAtStack", "popAtStack", "popAtStack",
                "push", "push", "push", "push", "push",
                "push", "push", "push", "push", "push",
                "push", "push", "push", "push", "push",
                "push", "push", "push", "push", "push",
                "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop"};
        var arr = new int[]{373, 86, 395, 306, 370,
                94, 41, 17, 387, 403,
                66, 82, 27, 335, 252,
                6, 269, 231, 35,
                346, 4, 6, 2, 5,
                2, 2, 7, 9, 8, 1, 474, 216, 256, 196, 332, 43, 75, 22, 273, 101, 11, 403, 33, 365, 338, 331, 134, 1, 250, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        DinnerPlates D2= new Q1172().new DinnerPlates(2);
        for(int i = 0 ; i < cmds.length ; i++){
            if("push".equals(cmds[i])){
                D2.push(arr[i]);
//                log("null");
            }else if("popAtStack".equals(cmds[i])){
                log(D2.popAtStack(arr[i]) + " popAtStack " + arr[i]);
//                D2.printStack();
            }else{
                log(D2.pop() + " pop " + arr[i] );
            }

        }


    }

    class DinnerPlates {

        public void printStack(){
            System.out.println("----");

            for(Stack<Integer> stack : stacks){
                System.out.println(stack);
            }
        }

        List<Stack<Integer>> stacks = new ArrayList<>();
        int maxCapa = 0;
        public DinnerPlates(int capacity) {
               maxCapa = capacity;
        }

        public void push(int val) {

            for(int i = 0 ; i < stacks.size() ; i++){
                if(stacks.get(i).size() < maxCapa){
                    stacks.get(i).push(val);
                    return;
                }
            }
            stacks.add(new Stack<>());
            stacks.getLast().push(val);

        }

        public int pop() {
            if(stacks.isEmpty()){
                return -1;
            }

            for(int i = stacks.size()-1 ; i >= 0 ; i--){
                if(stacks.get(i).isEmpty()){
                    stacks.remove(i);
                } else {
                    Stack<Integer> targetStack = stacks.get(i);
                    return targetStack.pop();
                }
            }

            return -1;
        }

        public int popAtStack(int index) {
            if(stacks.size()-1 < index){
                return -1;
            }
            Stack<Integer> targetStack = stacks.get(index);
            if(targetStack.isEmpty()){
                return -1;
            }
            int rtnVal = targetStack.pop();


            return rtnVal;
        }
    }

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
}
