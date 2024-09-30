public class QueueExample {
    private int[] queue; // 큐를 저장할 배열
    private int front; // 큐의 첫 번째 요소를 가리키는 인덱스
    private int rear; // 큐의 마지막 요소를 가리키는 인덱스
    private int capacity; // 큐의 크기 (배열의 크기)
    private int count; // 큐에 저장된 요소의 개수

    // 큐의 생성자 (크기를 입력받아 배열을 초기화)
    public QueueExample(int size) {
        queue = new int[size];
        capacity = size;
        front = 0; // 큐의 처음 위치를 0으로 설정
        rear = -1; // rear는 큐가 비었으므로 -1로 초기화
        count = 0; // 큐에 저장된 요소가 없으므로 0으로 초기화
    }

    // 큐에 요소를 추가 (enqueue)
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }

        // rear를 순환시키기 위해 (rear + 1) % capacity로 다음 위치를 설정
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        count++;
        System.out.println("Enqueued " + item);
    }

    // 큐에서 요소를 제거 (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int item = queue[front];
        front = (front + 1) % capacity; // front를 순환시키기 위해 (front + 1) % capacity로 다음 위치 설정
        count--;
        return item;
    }

    // 큐의 첫 번째 요소 확인 (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    // 큐가 비었는지 확인
    public boolean isEmpty() {
        return count == 0;
    }

    // 큐가 꽉 찼는지 확인
    public boolean isFull() {
        return count == capacity;
    }

    public static void main(String[] args) {
        QueueExample queue = new QueueExample(5); // 크기가 5인 큐 생성

        queue.enqueue(10); // 10 추가
        queue.enqueue(20); // 20 추가
        queue.enqueue(30); // 30 추가

        System.out.println("Front element: " + queue.peek()); // 큐의 첫 번째 요소 출력

        System.out.println("Dequeued: " + queue.dequeue()); // 큐에서 요소 제거
        System.out.println("Dequeued: " + queue.dequeue()); // 큐에서 요소 제거

        queue.enqueue(40); // 40 추가
        queue.enqueue(50); // 50 추가

        System.out.println("Front element: " + queue.peek()); // 큐의 첫 번째 요소 출력
    }
}
