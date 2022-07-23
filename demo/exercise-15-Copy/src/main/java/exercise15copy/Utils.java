package exercise15copy;

import java.util.Comparator;

public class Utils {
    // Generic findMax, with a function object.
    // Precondition: a.size() > 0.
    public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp) {
        int maxIndex = 0;

        for (int i=1; i < arr.length; i++) {
            if (cmp.compare(arr[i], arr[maxIndex]) > 0)
                maxIndex = i;
        }

        return arr[maxIndex];
    }
}
