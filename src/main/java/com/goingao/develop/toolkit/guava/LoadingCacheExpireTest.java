package com.goingao.develop.toolkit.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * FIXME
 *
 * @author goingao
 * @date 2019-03-22
 */
public class LoadingCacheExpireTest {

    public LoadingCache<String, String> loadingCache;
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    /**
     * 失效的时候，缓存 load 期间线程会阻塞
     */
    public LoadingCacheExpireTest() {
        loadingCache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build(
                new CacheLoader<String, String>() {
                    private AtomicInteger count = new AtomicInteger(1);
                    private AtomicInteger reloadCount = new AtomicInteger(1);

                    @Override
                    public String load(String key) throws Exception {
                        System.out.println("Load Value " + count.get() + " time(s)");
                        for (int i = 0; i < 10; i++) {
                            System.out.println("Load Value for " + i + " second(s)");
                            Thread.currentThread().sleep(1000);
                        }
                        count.incrementAndGet();
                        return "China";
                    }

                    @Override
                    public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
                        System.out.println("Reload for " + reloadCount.get() + " time(s)");
                        ListenableFutureTask<String> futureTask = ListenableFutureTask.create(() -> {
                            for (int i = 0; i < 10; i++) {
                                System.out.println("Reload Value for " + i + " second(s)");
                                Thread.currentThread().sleep(1000);
                            }
                            int count = reloadCount.incrementAndGet();
                            return "China" + count;
                        });
                        executorService.execute(futureTask);
                        return futureTask;
                    }
                });
    }

    public static void main(String[] args) {
        LoadingCacheExpireTest test = new LoadingCacheExpireTest();
        Runnable runnable1 = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println("Runnable1 Before Get Cache");
                    System.out.println("Runnable1 " + test.loadingCache.get("Country"));
                    System.out.println("Runnable1 After Get Cache");
                    Thread.currentThread().sleep(1000);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println("Runnable2 Before Get Cache");
                    System.out.println("Runnable2 " + test.loadingCache.get("Country"));
                    System.out.println("Runnable2 After Get Cache");
                    Thread.currentThread().sleep(1000);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
    }
}
