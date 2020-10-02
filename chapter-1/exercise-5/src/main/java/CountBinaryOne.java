import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class CountBinaryOne {
    private static final Logger logger = LoggerFactory.getLogger(CountBinaryOne.class);

    public static void main(String args[]) {
        CountBinaryOne countBinaryOne = new CountBinaryOne();

        Random random = new Random();
        long num = Math.abs(random.nextLong());

        logger.info("num: {}", num);
        logger.info("num: {}", String.format("%64s", Long.toBinaryString(num)));

        int oneCnt = countBinaryOne.count(num);

        logger.info("oneCnt: {}", oneCnt);
    }

    public int count(long num) {
        int cnt = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                cnt++;
            }

            num /= 2;
        }

        return cnt;
    }
}
