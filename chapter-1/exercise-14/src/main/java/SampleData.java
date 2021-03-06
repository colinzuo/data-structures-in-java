import java.util.Objects;

public class SampleData implements Comparable<SampleData> {
    private int x;
    private String str;

    public SampleData(int x, String str) {
        this.x = x;
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleData that = (SampleData) o;
        return x == that.x &&
                Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, str);
    }

    @Override
    public int compareTo(SampleData o) {
        if (x < o.x) {
            return -1;
        }

        if (x > o.x) {
            return 1;
        }

        return str.compareTo(o.str);
    }
}
