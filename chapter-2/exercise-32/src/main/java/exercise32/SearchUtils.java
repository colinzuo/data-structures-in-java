package exercise32;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchUtils {
    private static final Logger logger = LoggerFactory.getLogger(SearchUtils.class);
    public static final int NOT_FOUND = -1;

    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] arr, AnyType target) {
        logger.debug("arr: {}, target: {}", arr, target);

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (arr[low].compareTo(target) == 0) {
            logger.debug("found: {}", low);
            return low;
        }

        logger.debug("not found");
        return NOT_FOUND;
    }
}
