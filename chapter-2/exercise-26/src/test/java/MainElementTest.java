import exercise26.MainElement;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class MainElementTest {
    private static final Logger logger = LoggerFactory.getLogger(MainElementTest.class);

    @Test
    public void findMainElement() {
        MainElement mainElement = new MainElement();

        logger.debug("Start");

        // given
        List<Object> inList1 =
                Arrays.stream(new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4})
                        .boxed().collect(Collectors.toList());

        // then
        assertThat(mainElement.findMethod1(inList1)).isEqualTo(4);
        assertThat(mainElement.findMethod2(inList1)).isEqualTo(4);

        // given
        List<Object> inList2 =
                Arrays.stream(new int[]{3, 3, 4, 2, 4, 4, 2, 4})
                        .boxed().collect(Collectors.toList());

        // then
        assertThat(mainElement.findMethod1(inList2)).isNull();
        assertThat(mainElement.findMethod2(inList2)).isNull();

        // given
        List<Object> inList3 =
                Arrays.stream(new int[]{3, 3, 4, 2, 4, 4, 2, 4, 5})
                        .boxed().collect(Collectors.toList());

        // then
        assertThat(mainElement.findMethod1(inList3)).isNull();
        assertThat(mainElement.findMethod2(inList3)).isNull();

        // given
        List<Object> inList4 =
                Arrays.stream(new int[]{0, 5, 5, 3, 5, 7, 5, 5})
                        .boxed().collect(Collectors.toList());

        // then
        assertThat(mainElement.findMethod1(inList4)).isEqualTo(5);
        assertThat(mainElement.findMethod2(inList4)).isEqualTo(5);

        logger.debug("End");
    }
}
