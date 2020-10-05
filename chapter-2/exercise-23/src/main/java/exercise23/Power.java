package exercise23;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Power {
    private static final Logger logger = LoggerFactory.getLogger(Power.class);

    // order > 2
    public long power(long x, int order) {
        List<Long> subPowers = new ArrayList<>();

        int i = 1;
        int halfOrder = order / 2;
        long y = x;

        while (i <= halfOrder) {
            y = y * y;
            subPowers.add(y);
            i *= 2;
        }

        if (i == order) {
            return subPowers.get(subPowers.size() - 1);
        }

        int j = 0;
        long result = 1;

        for (int k=subPowers.size() - 1; k >= 0; k--) {
            if ((j + i) <= order) {
                j += i;
                result *= subPowers.get(k);

                if (j == order) {
                    return result;
                }
            }
            i /= 2;
        }

        while ((j + 1) <= order) {
            j += 1;
            result *= x;
        }

        return result;
    }
}
