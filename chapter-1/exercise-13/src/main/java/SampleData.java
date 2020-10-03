import java.util.Objects;

public class SampleData {
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
}
