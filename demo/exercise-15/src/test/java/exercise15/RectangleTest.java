package exercise15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;

public class RectangleTest {
    private static final Logger logger = LoggerFactory.getLogger(RectangleTest.class);

    //region setup & cleanup
    @BeforeEach
    public void setup(TestInfo testInfo) throws Exception {
        String displayName = testInfo.getDisplayName();

        logger.debug("{}: Enter setup", displayName);
    }

    @AfterEach
    public void cleanup(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();

        logger.debug("{}: Leave cleanup", displayName);
    }
    //endregion

    @Test
    public void combo() {
        Rectangle[] rectangles = {
                new Rectangle(100, 100),
                new Rectangle(100, 200),
                new Rectangle(200, 200),
                new Rectangle(300, 200),
                new Rectangle(1000, 10),
        };

        Rectangle maxAreaRec = Utils.findMax(rectangles, new RectangleAreaCompare());
        Rectangle maxPerimeterRec = Utils.findMax(rectangles, new RectanglePerimeterCompare());

        assertThat(maxAreaRec).isEqualTo(new Rectangle(300, 200));
        assertThat(maxPerimeterRec).isEqualTo(new Rectangle(1000, 10));
    }
}
