import java.util.concurrent.Semaphore;

class philosopher implements Runnable {
    int phil;
    private Semaphore room;
    private Semaphore chopsticks[];

    public philosopher(int phil, Semaphore room, Semaphore chopsticks[]) {
        this.phil = phil;
        this.room = room;
        this.chopsticks = chopsticks;
    }

    void eat() {
        System.out.println("Philosopher " + phil + " has started eating");
    }

    @Override
    public void run() {
        try {
            room.acquire();
            System.out.println("Philosopher " + phil + " has entered the room");
            chopsticks[phil].acquire();
            chopsticks[(phil + 1) % 5].acquire();
            eat();
            Thread.sleep(2000);
            System.out.println("Philosopher " + phil + " has finished eating");
            chopsticks[phil].release();
            chopsticks[(phil + 1) % 5].release();

            room.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class din_phi {
    public static void main(String[] args) {
        Semaphore room = new Semaphore(4);
        Semaphore chopsticks[] = new Semaphore[5];
        for (int i = 0; i < 5; i++)
            chopsticks[i] = new Semaphore(1);

        Thread threads[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new philosopher(i, room, chopsticks));
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
