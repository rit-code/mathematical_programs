package thread_programs;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        MessageDrop drop = new MessageDrop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
