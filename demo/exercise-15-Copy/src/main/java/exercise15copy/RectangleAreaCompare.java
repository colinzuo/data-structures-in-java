package exercise15copy;

import java.util.Comparator;

public class RectangleAreaCompare implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        long area1 = o1.getLength() * o1.getWidth();
        long area2 = o2.getLength() * o2.getWidth();

        return Long.compare(area1, area2);
    }
}
