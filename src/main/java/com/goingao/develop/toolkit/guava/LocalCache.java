package com.goingao.develop.toolkit.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * FIXME
 *
 * @author goingao
 * @date 2019-03-18
 */
public class LocalCache {
    /**
     * cacheloader，比较宽泛，针对整个 cache
     */
    private static void cacheLoadingTest() {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build(
                new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return "gy";
                    }
                }
        );

        try {
            System.out.println(cache.getIfPresent("name"));
            System.out.println(cache.get("name"));
            System.out.println(cache.get("name", new Callable<String>(){
                @Override
                public String call() throws Exception {
                    return "高禹";
                }
            }));
            System.out.println(cache.get("name2", new Callable<String>(){
                @Override
                public String call() throws Exception {
                    return "高禹2";
                }
            }));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * callable，在 get 时指定，比较灵活
     */
    private static void cacheCallTest() {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String name = null;
        try {
            name = cache.get("name", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "goingao";
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(name);
    }

    public static void main(String[] args) {
        cacheLoadingTest();
        cacheCallTest();
    }
}
