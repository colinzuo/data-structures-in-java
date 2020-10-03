import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;

public class CollectionTest {
    private static final Logger logger = LoggerFactory.getLogger(CollectionTest.class);

    @Test
    public void combo() {
        // given
        Collection<SampleData> collection = new Collection<>();

        // then
        assertThat(collection.isEmpty()).isTrue();

        // given
        collection.insert(0, new SampleData(1, "Sample 1"));

        // then
        assertThat(collection.isEmpty()).isFalse();

        // given
        Throwable thrown = catchThrowable(() -> { collection.insert(3, new SampleData(2, "Sample 2")); });

        // then
        assertThat(thrown).isInstanceOf(RuntimeException.class);

        // given
        collection.makeEmpty();

        // then
        assertThat(collection.isEmpty()).isTrue();

        // given
        collection.insert(0, new SampleData(1, "Sample 1"));
        collection.insert(1, new SampleData(2, "Sample 2"));

        // then
        assertThat(collection.isPresent(new SampleData(1, "Sample 1"))).isTrue();

        // given
        collection.remove(0);

        // then
        assertThat(collection.isPresent(new SampleData(1, "Sample 1"))).isFalse();
    }
}
