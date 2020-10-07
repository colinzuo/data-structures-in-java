package exercise23;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;

public class PowerTest {
    private static final Logger logger = LoggerFactory.getLogger(PowerTest.class);

    @Test
    public void power() {
        Power power = new Power();

        logger.debug("Start");

        long mathResult1 = (long) Math.pow(6, 3);
        logger.debug("Math.pow(6, 3) result: {}", mathResult1);

        long mathResult2 = (long) Math.pow(15, 3);
        logger.debug("Math.pow(15, 3) result: {}", mathResult2);

        long mathResult3 = (long) Math.pow(2, 62);
        logger.debug("Math.pow(2, 62) result: {}", mathResult3);

        assertThat(power.power(6, 3)).isEqualTo(mathResult1);
        assertThat(power.power(15, 3)).isEqualTo(mathResult2);
        assertThat(power.power(2, 62)).isEqualTo(mathResult3);

        logger.debug("Again");

        assertThat(power.power(2, 3)).isEqualTo(8);
        assertThat(power.power(2, 9)).isEqualTo(512);
        assertThat(power.power(2, 10)).isEqualTo(1024);

        assertThat(power.power(6, 3)).isEqualTo(mathResult1);
        assertThat(power.power(15, 3)).isEqualTo(mathResult2);
        assertThat(power.power(2, 62)).isEqualTo(mathResult3);

        logger.debug("Done");
    }
}
