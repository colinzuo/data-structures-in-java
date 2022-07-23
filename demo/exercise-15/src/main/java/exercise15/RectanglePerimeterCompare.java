package exercise15;

import java.util.Comparator;

public class RectanglePerimeterCompare implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        long perimeter1 = 2 * (o1.getLength() + o1.getWidth());
        long perimeter2 = 2 * (o2.getLength() + o2.getWidth());

        return Long.compare(perimeter1, perimeter2);
    }
}
