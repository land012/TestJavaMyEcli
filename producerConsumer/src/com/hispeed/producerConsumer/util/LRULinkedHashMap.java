package com.hispeed.producerConsumer.util;
import java.util.LinkedHashMap;  
import java.util.concurrent.locks.Lock;  
import java.util.concurrent.locks.ReentrantLock;  
  
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V>  
{  
    private final int maxCapacity;  
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;  
    private final Lock lock = new ReentrantLock();  
  
    public LRULinkedHashMap(int maxCapacity)  
    {  
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);  
        this.maxCapacity = maxCapacity;  
    }  
  
    @Override  
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest)  
    {  
        return size() > maxCapacity;  
    }  
  
    @Override  
    public V get(Object key)  
    {  
        try {  
            lock.lock();  
            return super.get(key);  
        }  
        finally {  
            lock.unlock();  
        }  
    }  
  
    @Override  
    public V put(K key, V value)  
    {  
        try {  
            lock.lock();  
            return super.put(key, value);  
        }  
        finally {  
            lock.unlock();  
        }
    }
    
    /**
     * 如果编译版本为 jdk7的话，这里会报错
     * @param key
     */
//    public void remove(K key)  
//    {  
//        try {  
//            lock.lock();  
//            super.remove(key);  
//        }  
//        finally {  
//            lock.unlock();  
//        }  
//    }
    public V remove(Object key)  
    {  
        try {  
            lock.lock();  
            return super.remove(key);  
        }  
        finally {  
            lock.unlock();  
        }  
    }
    
    public int size()  
    {  
        try {  
            lock.lock();  
            return super.size();  
        }  
        finally {  
            lock.unlock();  
        }  
    }  
} 