package exercise15;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;

public class RectangleTest {
    private static final Logger logger = LoggerFactory.getLogger(RectangleTest.class);

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
