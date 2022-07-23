import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;

public class OrderedCollectionTest {
    private static final Logger logger = LoggerFactory.getLogger(OrderedCollectionTest.class);

    @Test
    public void combo() {
        // given
        OrderedCollection<SampleData> collection = new OrderedCollection<>();

        // then
        assertThat(collection.isEmpty()).isTrue();

        // given
        collection.insert(new SampleData(1, "Sample 1"));

        // then
        assertThat(collection.isEmpty()).isFalse();

        // given
        collection.makeEmpty();

        // then
        assertThat(collection.isEmpty()).isTrue();

        // given
        collection.insert(new SampleData(1, "Sample 1"));
        collection.insert(new SampleData(2, "Sample 2"));
        collection.insert(new SampleData(5, "Sample 5"));
        collection.insert(new SampleData(4, "Sample 4"));
        collection.insert(new SampleData(6, "Sample 6"));

        // then
        assertThat(collection.isPresent(new SampleData(1, "Sample 1"))).isTrue();
        assertThat(collection.findMin()).isEqualTo(new SampleData(1, "Sample 1"));
        assertThat(collection.findMax()).isEqualTo(new SampleData(6, "Sample 6"));

        // given
        collection.remove(new SampleData(1, "Sample 1"));

        // then
        assertThat(collection.isPresent(new SampleData(1, "Sample 1"))).isFalse();
        assertThat(collection.findMin()).isEqualTo(new SampleData(2, "Sample 2"));
        assertThat(collection.findMax()).isEqualTo(new SampleData(6, "Sample 6"));
    }
}
