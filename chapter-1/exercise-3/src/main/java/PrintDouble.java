import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class PrintDouble {
    private static final Logger logger = LoggerFactory.getLogger(PrintDouble.class);

    public static void main(String args[]) {
        Random random = new Random();
        double target = random.nextInt() + random.nextDouble();

        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);

        // double has 15 - 17 decimal precision
        logger.info("Target {}", String.format("%.15f", target));
        logger.info("Target {}", df.format(target));
        logger.info("Target {}", new BigDecimal(target).toPlainString());

        PrintDouble printDouble = new PrintDouble();

        System.out.println("");
        printDouble.print(target);
        System.out.println("");
    }

    public void print(double target) {
        if (target < 0) {
            System.out.print("-");
            target *= -1;
        }
        long integralPart = (long) target;
        int fractionalPrecision = 15;
        if (integralPart == 0) {
            System.out.print("0");
        } else {
            List<Integer> intPartList = new ArrayList<>();
            while (integralPart != 0) {
                int part = (int) (integralPart % 10);
                integralPart = integralPart / 10;

                intPartList.add(0, part);
            }

            for (int intPart : intPartList) {
                printDigit(intPart);
            }

            fractionalPrecision -= intPartList.size();
        }
        if (fractionalPrecision > 0) {
            long factionalPart = Math.round((target - (long) target) * Math.pow(10, fractionalPrecision));

            List<Integer> fracPartList = new ArrayList<>();
            boolean metNonZero = false;
            for (int i=0; i < fractionalPrecision; i++) {
                int part = (int) (factionalPart % 10);
                factionalPart = factionalPart / 10;

                if (part != 0) {
                    metNonZero = true;
                }

                if (metNonZero) {
                    fracPartList.add(0, part);
                }
            }

            System.out.print(".");
            for (int fracPart : fracPartList) {
                printDigit(fracPart);
            }
        }
    }

    public void printDigit(int digit) {
        System.out.print(digit);
    }
}
