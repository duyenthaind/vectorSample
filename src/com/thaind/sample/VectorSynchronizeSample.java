package com.thaind.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VectorSynchronizeSample {

    private static final Vector<Integer> VECTOR = new Vector<>();
    private static final List<Integer> ARRAYLIST = new ArrayList<>();
    private static final ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {

        Thread vectorWorker = new Thread(() -> {
            Thread.currentThread().setName("Vector_worker");
            for (int index = -1; ++index < 30000;) {
                Thread thr = new Thread("Vector_worker_index_" + index) {
                    @Override
                    public void run() {
                        VECTOR.add(new Random().nextInt(10));
                        System.out.println(this.getName());
                    }
                };
                threadPool.execute(thr);
            }

        });

        Thread arrayListWorker = new Thread(() -> {
            Thread.currentThread().setName("Arraylist_worker");
            for (int index = -1; ++index < 30000;) {
                Thread thr = new Thread("Arraylist_worker_index_" + index) {
                    @Override
                    public void run() {
                        ARRAYLIST.add(new Random().nextInt(10));
                        System.out.println(this.getName());
                    }

                };

                threadPool.execute(thr);
            }

        });

        vectorWorker.start();
        arrayListWorker.start();

        if (!threadPool.awaitTermination(5, TimeUnit.SECONDS)) {
            threadPool.shutdownNow();
        }
        while (!threadPool.isShutdown()) {
        }

        System.out.println("Vector: ");
        System.out.println("--------------------------------Size" + VECTOR.size());
        System.out.println("\nArrayList: ");
        System.out.println("--------------------------------Size" + ARRAYLIST.size());
        System.exit(0);
    }

}
