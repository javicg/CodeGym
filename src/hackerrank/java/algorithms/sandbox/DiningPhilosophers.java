package algorithms.sandbox;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    public static void main(String[] args) {
        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);
        Fork fork4 = new Fork(4);
        Fork fork5 = new Fork(5);

        Philosopher ar = new Philosopher("Aristoteles", fork5, fork1);
        Philosopher ke = new Philosopher("Kepler", fork1, fork2);
        Philosopher eu = new Philosopher("Euclides", fork2, fork3);
        Philosopher so = new Philosopher("Socrates", fork3, fork4);
        Philosopher pi = new Philosopher("Pitagoras", fork4, fork5);

        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.submit(ar);
        pool.submit(eu);
        pool.submit(ke);
        pool.submit(so);
        pool.submit(pi);

        pool.shutdown();
        try {
            pool.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Philosopher implements Runnable {
        private final String name;
        private final Fork leftFork;
        private final Fork rightFork;

        public Philosopher(String name, Fork leftFork, Fork rightFork) {
            this.name = name;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        @Override
        public void run() {
            int count = 0;
            while (count < 5) {
                if (tryEat()) {
                    count++;
                }
                meditate();
            }
            System.out.println(name + " finished eating. Goodbye!");
        }

        public boolean tryEat() {
            if (leftFork.pickUp(name)) {
                if (rightFork.pickUp(name)) {
                    eat();
                    rightFork.dropOff(name);
                    leftFork.dropOff(name);
                    return true;
                } else {
                    leftFork.dropOff(name);
                }
            }
            return false;
        }

        public void eat() {
            System.out.println(name + " is eating. Yummy!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void meditate() {
            System.out.println(name + " is meditating...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Fork {
        private final Lock lock = new ReentrantLock();
        private final int forkNumber;

        public Fork(int forkNumber) {
            this.forkNumber = forkNumber;
        }

        public boolean pickUp(String philosopher) {
            if (lock.tryLock()) {
                System.out.println(philosopher + " picked up fork " + forkNumber);
                return true;
            }
            return false;
        }

        public void dropOff(String philosopher) {
            lock.unlock();
            System.out.println(philosopher + " dropped off fork " + forkNumber);
        }
    }
}
