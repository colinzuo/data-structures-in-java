import exercise28.PositiveArrayFinder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;

public class PositiveArrayFinderTest {
    private static final Logger logger = LoggerFactory.getLogger(PositiveArrayFinderTest.class);

    @Test
    public void find() {
        PositiveArrayFinder positiveArrayFinder = new PositiveArrayFinder();

        logger.debug("Start");

        // given
        double[] arr1 = new double[]{5, 4, 1, 2, 3, 4, 5};

        // when
        double max1_1 = positiveArrayFinder.findMaxOfAjMinusAi(arr1);
        double max1_2 = positiveArrayFinder.findMaxOfAjDivideAi(arr1);

        // then
        assertThat(max1_1).isCloseTo(4, offset(1e-5));
        assertThat(max1_2).isCloseTo(5, offset(1e-5));

        // given
        double[] arr2 = new double[]{8, 10, 20, 9, 7, 6, 3, 9, 10};

        // when
        double max2_1 = positiveArrayFinder.findMaxOfAjMinusAi(arr2);
        double max2_2 = positiveArrayFinder.findMaxOfAjDivideAi(arr2);

        // then
        assertThat(max2_1).isCloseTo(12, offset(1e-5));
        assertThat(max2_2).isCloseTo(10.0/3, offset(1e-5));

        logger.debug("End");
    }
}
