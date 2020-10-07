import exercise27.SortedMatrixFinder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;

public class SortedMatrixFinderTest {
    private static final Logger logger = LoggerFactory.getLogger(SortedMatrixFinderTest.class);

    @Test
    public void find() {
        SortedMatrixFinder sortedMatrixFinder = new SortedMatrixFinder();

        logger.debug("Start");

        // given
        double[][] arr1 = new double[][]{
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 5.4, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9},
        };

        // when
        SortedMatrixFinder.Result result1 = sortedMatrixFinder.find(5.5, arr1);

        // then
        assertThat(result1.isFound()).isFalse();

        // when
        SortedMatrixFinder.Result result2 = sortedMatrixFinder.find(5.4, arr1);

        // then
        assertThat(result2.isFound()).isTrue();
        assertThat(result2.getDim1()).isEqualTo(2);
        assertThat(result2.getDim2()).isEqualTo(3);

        // given
        double[][] arr2 = new double[][]{
                {1, 2, 3, 4, 5},
                {20, 30, 40, 50, 60},
        };

        // when
        SortedMatrixFinder.Result result21 = sortedMatrixFinder.find(3.5, arr2);

        // then
        assertThat(result21.isFound()).isFalse();

        // when
        SortedMatrixFinder.Result result22 = sortedMatrixFinder.find(4, arr2);

        // then
        assertThat(result22.isFound()).isTrue();
        assertThat(result22.getDim1()).isEqualTo(0);
        assertThat(result22.getDim2()).isEqualTo(3);

        // when
        SortedMatrixFinder.Result result23 = sortedMatrixFinder.find(20, arr2);

        // then
        assertThat(result23.isFound()).isTrue();
        assertThat(result23.getDim1()).isEqualTo(1);
        assertThat(result23.getDim2()).isEqualTo(0);

        logger.debug("End");
    }
}
