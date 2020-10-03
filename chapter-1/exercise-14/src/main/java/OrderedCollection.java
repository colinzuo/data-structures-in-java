import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderedCollection<T extends Comparable<T>> {
    private static final Logger logger = LoggerFactory.getLogger(OrderedCollection.class);
    private Object[] objects = new Object[100];
    private int len;

    public boolean isEmpty() {
        return len == 0;
    }

    public void makeEmpty() {
        len = 0;
    }

    public void insert(T obj) {
        if (len == objects.length) {
            Object[] newObjects = new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }

        int i = 0;
        for (; i < len; i++) {
            T comparable = (T)objects[i];
            if (comparable.compareTo(obj) <= 0) {
                continue;
            }
        }

        System.arraycopy(objects, i, objects, i+1, len-i);

        objects[i] = obj;
        len++;
    }

    public T remove(T obj) {
        int i=0;
        for (; i < len; i++) {
            Object object = objects[i];

            if (object.equals(obj)) {
                break;
            }
        }

        if (i == len) {
            return null;
        }

        Object toRemove = objects[i];
        System.arraycopy(objects, i+1, objects, i, len-i-1);

        return (T)toRemove;
    }

    public boolean isPresent(T obj) {
        for (int i=0; i < len; i++) {
            Object object = objects[i];

            if (object.equals(obj)) {
                return true;
            }
        }

        return false;
    }

    public T findMin() {
        if (len == 0) {
            return null;
        }

        return (T)objects[0];
    }

    public T findMax() {
        if (len == 0) {
            return null;
        }

        return (T)objects[len - 1];
    }
}
