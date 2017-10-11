package com.shenyang.core;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 缓存图片工具类
 */
public class PicCacheManager {
    private static LoadingCache<Integer, byte[]> cache;

    private static class Inner {
        public static PicCacheManager picCacheManager = new PicCacheManager();
    }

    private PicCacheManager() {
        cache = CacheBuilder.newBuilder().maximumSize(100).
                expireAfterAccess(10, TimeUnit.MINUTES).build(new CacheLoader<Integer, byte[]>() {
            @Override
            public byte[] load(Integer id) throws Exception {
                return new byte[0];
            }
        });
    }

    public byte[] get(int userId) throws ExecutionException {
        return cache.get(userId);
    }

    public void put(int userId, byte[] img) {
        cache.put(userId, img);
    }

    public static PicCacheManager getInstance() {
        return Inner.picCacheManager;
    }
}
