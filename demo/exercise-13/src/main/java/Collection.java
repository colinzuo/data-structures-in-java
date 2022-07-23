import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Collection<T> {
    private static final Logger logger = LoggerFactory.getLogger(Collection.class);
    private Object[] objects = new Object[100];
    private int len;

    public boolean isEmpty() {
        return len == 0;
    }

    public void makeEmpty() {
        len = 0;
    }

    public void insert(int i, T obj) {
        if (i < 0 || i > len) {
            throw new RuntimeException("insert position invalid");
        }

        if (len == objects.length) {
            Object[] newObjects = new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }

        System.arraycopy(objects, i, objects, i+1, len-i);

        objects[i] = obj;
        len++;
    }

    public T remove(int i) {
        if (i < 0 || i >= len) {
            throw new RuntimeException("remove position invalid");
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
}
