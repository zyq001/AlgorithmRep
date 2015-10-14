package edu.bupt.zyq.list;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by root on 15-10-15.
 */
public class ProduceConsumerQueue {
    public Object[] queue;
    int cap, putPos = 0, takePos = 0, size = 0;

    public ProduceConsumerQueue(int cap){
        queue = new Object[cap];
        this.cap = cap;
    }

    public synchronized void produce(){
        while(cap == size){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        putPos = putPos % cap;
        queue[putPos++] = new Object();
        size++;
        System.out.println("Produce, size = " + size + "next put pos:" + putPos + "--takePos: " + takePos);
        notify();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void consume(){
        while(size == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        takePos = takePos % cap;
        queue[takePos++] = null;
        size--;
        System.out.println("Consume, size = " + size + "next put pos:" + putPos + "--takePos: " + takePos);

        notify();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        ProduceConsumerQueue queue = new ProduceConsumerQueue(1000);
        new Thread(new Consumer(queue)).start();
        new Thread(new Producer(queue)).start();
    }
}

class Producer implements Runnable{
    private ProduceConsumerQueue queque;
    public Producer(ProduceConsumerQueue queque){
        this.queque = queque;
    }



    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        while (true) queque.produce();
    }
}

class Consumer implements Runnable{
    private ProduceConsumerQueue queue;

    public Consumer(ProduceConsumerQueue queque){
        this.queue = queque;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        while (true) queue.consume();
    }
}
