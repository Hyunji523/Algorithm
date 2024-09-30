import java.util.Stack;

public class StackExample {

    private int maxSize; // 최대 사이즈
    private int[] arr; // 요소를 담을 내부 배열
    private int top; // 스택의 가장 마지막 요소를 가리키는 인덱스(포인터)

    // 생성자
    public StackExample(int size) {
        this.arr = new int[size]; // 입력한 용량으로 내부 배열 생성
        this.maxSize = size;
        this.top = -1;
    }

    // isFull : 스택이 꽉 차있으면 true
    // 마지막 요소 위치인 top이 (배열 길이 - 1)과 같은 경우 끝까지 차있는 것과 같음
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // isEmpty : 스택이 비어있으면 true
    // 마지막 요소 위치인 top이 -1을 가리키는 경우, 배열이 비어있는 것과 같음
    public boolean isEmpty() {
        return top == -1;
    }

    // push : 스택에 요소 추가
    public void push(int data) {
        if (isFull()) {
            System.out.println("스택이 꽉 차있습니다.");
            return;
        }
        // 스택이 꽉 차있지않다면 맨 위에 데이터 추가
        arr[++top] = data;
    }

    // pop : 스택 마지막 요소 제거
    public int pop() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return -1;
        }
        // 스택이 비어있지않다면 맨 위 데이터 제거 후 반환
        return arr[top--];
    }

    // peek : 스택 마지막 요소 반환
    public int peek() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return -1;
        }
        // 스택이 비어있지않다면 맨 위 데이터 반환
        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackExample mystack = new StackExample(6);
        mystack.push(100);
        mystack.push(200);
        mystack.push(300);

        System.out.println("스택 크기: " + mystack.size()); // 출력: 3
        System.out.println("맨 위 데이터: " + mystack.peek()); // 출력: 300

        System.out.println("Pop한 데이터: " + mystack.pop()); // 출력: 300
        System.out.println("Pop한 데이터: " + mystack.pop()); // 출력: 200
        System.out.println("스택이 비어있는지 확인: " + mystack.isEmpty()); // 출력: false

        System.out.println("Pop한 데이터: " + mystack.pop()); // 출력: 100
        System.out.println("스택이 비어있는지 확인: " + mystack.isEmpty()); // 출력: true
    }

    public static void javaStack() {
        Stack<Integer> stack = new Stack<>();

        // push(데이터) : 데이터 삽입
        stack.push(1);
        stack.push(3);
        stack.push(5);
        System.out.println("스택:" + stack);

        // peek() : 맨 위 데이터 확인
        System.out.println("peek(맨 위 데이터) : " + stack.peek());

        // pop() : 데이터 제거 (가장 최근에 들어간)
        System.out.println("제거할 데이터 : " + stack.pop());
        System.out.println("스택 : " + stack);

        // isEmpty() : 스택이 비어있는지 확인
        System.out.println("비어있는 스택인가요? " + stack.isEmpty());
    }
}