import exercise32.SearchUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;

public class SearchUtilsTest {
    private static final Logger logger = LoggerFactory.getLogger(SearchUtilsTest.class);

    @Test
    public void binarySearch() {
        logger.debug("Start");

        // given
        Integer[] arr1 = new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23};

        // when, then
        for (int i=0; i < arr1.length; i++) {
            int idx = SearchUtils.binarySearch(arr1, arr1[i]);

            assertThat(idx).isEqualTo(i);
        }

        // when
        int idx1_1 = SearchUtils.binarySearch(arr1, 10);

        // then
        assertThat(idx1_1).isEqualTo(SearchUtils.NOT_FOUND);

        logger.debug("End");
    }
}
