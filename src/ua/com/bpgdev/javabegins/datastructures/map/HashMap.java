package ua.com.bpgdev.javabegins.datastructures.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class  HashMap<K,V> implements Map {
    private static final int INITIAL_BUCKET_COUNT = 4;
    private static final double DEFAULT_LOAD_FACTOR = 0.75f;
    private double threshold;
    private ArrayList<Entry<K, V>>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashMap() {
        buckets = new ArrayList[INITIAL_BUCKET_COUNT];
        threshold = INITIAL_BUCKET_COUNT * DEFAULT_LOAD_FACTOR;
    }

    @Override
    public Object put(Object key, Object value) {
        if (key == null) {
            return putKeyEqualNull(value);
        }

        int bucketIndex = getBucketIndex(key);
        ArrayList<Entry<K,V>> bucket = buckets[bucketIndex];

        if (bucket != null) {
            for (Entry e : bucket) {
                if (Objects.equals(key, e.getKey())) {
                    if (Objects.equals(e.getValue(), value)) {
                        return value;
                    } else {
                        Object oldValue = e.getValue();
                        e.setValue(value);
                        return oldValue;
                    }
                }
            }
        } else {
            buckets[bucketIndex] = bucket = new ArrayList<>();
        }

        bucket.add(new Entry(key, value));
        size++;
        if (size >= (threshold)) {
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
        ArrayList<Entry<K,V>> bucket = buckets[getBucketIndex(key)];

        if (bucket != null) {
            for (Entry e : bucket) {
                if (Objects.equals(key, e.getKey())) {
                    return null;
                }
            }
        } else {
            buckets[getBucketIndex(key)] = bucket = new ArrayList<>();
        }

        bucket.add(entry);
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
        int bucketIndex;
        if (key == null) {
            bucketIndex = 0;
        } else {
            bucketIndex = getBucketIndex(key);
        }

        ArrayList<Entry<K,V>> bucket = buckets[bucketIndex];

        if (bucket != null) {
            for (Entry e : bucket) {
                if (Objects.equals(key, e.getKey())) {
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
        ArrayList<Entry<K,V>> bucket = buckets[getBucketIndex(key)];
        if (bucket != null) {
            Entry entry = null;
            for (Entry e : bucket) {
                if (Objects.equals(key, e.getKey())) {
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
        for (ArrayList<Entry<K,V>> bucket : buckets) {
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
        for (ArrayList<Entry<K,V>> bucket : buckets) {
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
        return Math.abs(key.hashCode() % buckets.length);
    }

    private void increaseHashMap() {

        ArrayList<Entry>[] oldBuckets = new ArrayList[buckets.length];
        System.arraycopy(buckets, 0, oldBuckets, 0, buckets.length);

        buckets = new ArrayList[buckets.length * 2];
        size = 0;
        threshold = buckets.length * DEFAULT_LOAD_FACTOR;

        for (ArrayList<Entry> bucket : oldBuckets) {
            if (bucket != null)
                for (Entry e : bucket) {
                    put(e.getKey(), e.getValue());
                }
        }

    }

    private Object putKeyEqualNull(Object value) {
        if (buckets[0] != null) {
            for (Entry e : buckets[0]) {
                if (e.key == null) {
                    Object oldValue = e.getValue();
                    e.setValue(value);
                    return oldValue;
                }
            }
        } else {
            buckets[0] = new ArrayList<>();
        }
        buckets[0].add(new Entry(null, value));
        size++;
        return null;
    }

    private static class Entry<K,V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }
    }


}
