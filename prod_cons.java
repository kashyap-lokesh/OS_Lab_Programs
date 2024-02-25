import java.util.concurrent.Semaphore;

class Que {
    int item;
    static Semaphore con = new Semaphore(0);
    static Semaphore prod = new Semaphore(1);

    void get() {
        try {
            con.acquire();
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception caught");
        }
        System.out.println("Consumer consumed the item " + item);
        prod.release();
    }

    void put(int item) {
        try {
            prod.acquire();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception caught");
        }
        this.item = item;
        System.out.println("Producer produced the item " + item);
        con.release();
    }
}

class producer implements Runnable {
    Que q;

    producer(Que q) {
        this.q = q;
        new Thread(this, "producer").start();
    }

    public void run() {
        for (int i = 0; i < 5; i++)
            q.put(i);
    }
}

class consumer implements Runnable {
    Que q;

    consumer(Que q) {
        this.q = q;
        new Thread(this, "consumer").start();
    }

    public void run() {
        for (int i = 0; i < 5; i++)
            q.get();
    }
}

public class prod_cons {
    public static void main(String[] args) {
        Que q = new Que();
        new producer(q);
        new consumer(q);
    }
}
