package ua.com.bpgdev.javabegins.datastructures.map;

import java.util.ArrayList;
import java.util.List;

public class HashMap implements Map {
    private static final int INITIAL_BUCKET_COUNT = 4;
    static final double DEFAULT_LOAD_FACTOR = 0.75f;
    private double treshhold;
    private ArrayList<Entry>[] buckets;
    private int size;

    public HashMap() {
        buckets = new ArrayList[INITIAL_BUCKET_COUNT];
        treshhold = INITIAL_BUCKET_COUNT * DEFAULT_LOAD_FACTOR;
    }

    @Override
    public Object put(Object key, Object value) {
        if (key == null) {
            /*
            TODO: Implement null key logic with return from the method in this block
            TODO: Zero (0) bucket is used for null key item
            * */
            return null;
        }

        Entry entry = new Entry(key, value);
        ArrayList<Entry> bucket = buckets[getBucketIndex(key)];

        if (bucket != null) {
            for (Entry e : bucket) {
                if (e.getKey() == key && !e.getValue().equals(value)) {
                    Object oldValue = e.getValue();
                    e.setValue(value);
                    return oldValue;
                }
            }
            bucket.add(entry);
            size++;
            return null;
        }

        buckets[getBucketIndex(key)] = new ArrayList();
        buckets[getBucketIndex(key)].add(entry);
        size++;
        if (size >= (treshhold)) {
            increaseHashMap();
        }
        return null;
    }

    @Override
    public Object putIfAbsent(Object key, Object value) {
        if (key == null) {
            /*
            TODO: Implement null key logic with return from the method in this block
            TODO: Zero (0) bucket is used for null key item
            * */
            return null;
        }
        Entry entry = new Entry(key, value);
        ArrayList<Entry> bucket = buckets[getBucketIndex(key)];

        if (bucket != null) {
            for (Entry e : bucket) {
                if (e.getKey() == key) {
                    return null;
                }
            }
            bucket.add(entry);
            size++;
            return value;
        }
        buckets[getBucketIndex(key)] = new ArrayList();
        buckets[getBucketIndex(key)].add(entry);
        size++;
        return value;
    }

    @Override
    public void putAll(HashMap map) {
        for (ArrayList<Entry> bucket : map.buckets) {
            if (bucket != null) {
                for (Entry e : bucket) {
                    put(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Object get(Object key) {
        if (key == null) {
            /*
            TODO: Implement null key logic with return from the method in this block
            TODO: Zero (0) bucket is used for null key item
            * */
            return null;
        }
        ArrayList<Entry> bucket = buckets[getBucketIndex(key)];

        if (bucket != null) {
            for (Entry e : bucket) {
                if (e.getKey() == key) {
                    return e.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        if (key == null) {
            /*
            TODO: Implement null key logic with return from the method in this block
            TODO: Zero (0) bucket is used for null key item
            * */
            return null;
        }
        ArrayList<Entry> bucket = buckets[getBucketIndex(key)];
        if (bucket != null) {
            Entry entry = null;
            for (Entry e : bucket) {
                if (e.getKey() == key) {
                    entry = e;
                }
            }
            if (entry != null) {
                bucket.remove(entry);
                size--;
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public List keys() {
        ArrayList<Object> keysList = new ArrayList<>();
        for (ArrayList<Entry> bucket : buckets) {
            if (bucket != null) {
                for (Entry e : bucket) {
                    keysList.add(e.getKey());
                }
            }
        }
        return keysList;
    }

    @Override
    public List values() {
        ArrayList<Object> keysList = new ArrayList<>();
        for (ArrayList<Entry> bucket : buckets) {
            if (bucket != null) {
                for (Entry e : bucket) {
                    keysList.add(e.getValue());
                }
            }
        }
        return keysList;
    }

    @Override
    public boolean containsKey(Object key) {
        return keys().contains(key);
    }

    @Override
    public int size() {
        return size;
    }

    private int getBucketIndex(Object key) {
        return (key.hashCode() % buckets.length);
    }

    private void increaseHashMap() {
        //System.out.println("Increase array!");

        ArrayList<Entry>[] oldBuckets = new ArrayList[buckets.length];
        System.arraycopy(buckets, 0, oldBuckets, 0, buckets.length);

        buckets = new ArrayList[buckets.length * 2];
        size = 0;
        treshhold = buckets.length * DEFAULT_LOAD_FACTOR;

        for (ArrayList<Entry> bucket : oldBuckets) {
            if (bucket != null)
                for (Entry e : bucket) {
                    put(e.getKey(), e.getValue());
                }
        }

    }
}
