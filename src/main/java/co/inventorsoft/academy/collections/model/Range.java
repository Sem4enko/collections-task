package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private HashSet<T> set;

    private Range() {

        set = new HashSet<>();
    }


    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public boolean contains(Object o) {
        return set.contains(o);
    }

    public Iterator<T> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return set.toArray(a);
    }

    public boolean add(T t) {
        return set.add(t);
    }

    public boolean remove(Object o) {
        return set.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return set.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return removeAll(c);
    }

    public void clear() {
        set.clear();
    }

    public static <K extends Comparable> Range<K> of(K a, K d, Function<K, K> add) {

        Range<K> range = new Range<>();

        if (a.compareTo(d) == 0) {
            return range;
        }
        K next = a;
        while (next.compareTo(d) <= 0) {
            range.add(next);
            next = add.apply(next);
        }

        return range;

    }

    public static Range<Integer> of(int from, int to) {
        return of(from, to, integer -> integer + 1);
    }

    public static Range<Double> of(double from, double to) {
        return of(from, to, aDouble -> aDouble + 0.1);
    }

    public static Range<Float> of(float from, float to) {
        return of(from, to, aFloat -> aFloat + 0.1f);
    }

    public static Range<Short> of(short from, short to) {
        return of(from, to, aShort -> (short) (aShort + 1));
    }

    public static Range<Byte> of(byte from, byte to) {
        return of(from, to, aByte -> (byte) (aByte + 1));
    }

    public static Range<Long> of(long from, long to) {
        return of(from, to, aLong -> (long) (aLong + 1));
    }
}
