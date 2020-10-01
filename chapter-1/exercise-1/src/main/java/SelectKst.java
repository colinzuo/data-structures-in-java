import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectKst {
    private static final Logger logger = LoggerFactory.getLogger(SelectKst.class);

    public static enum Method {
        BubbleSort,
        DivideSelect
    }

    public static void main(String args[]) {
        List<Method> methods = new ArrayList<>();

        methods.add(Method.DivideSelect);
        methods.add(Method.BubbleSort);

        int[] lengthList = new int[]{10000, 100000, 200000};

        for (int length : lengthList) {
            int k = length / 2;

            logger.info("Enter: length {}, k {}", length, k);

            Random random = new Random();

            double[] inNums = new double[length];
            double[] outNums = new double[length];

            for (int i = 0; i < inNums.length; i++) {
                inNums[i] = random.nextDouble();
            }

            logger.info("Generate number done");

            SelectKst selectKst = new SelectKst();

            for (Method method : methods) {
                System.arraycopy(inNums, 0, outNums, 0, inNums.length);

                long startTime = System.currentTimeMillis();
                long duration;

                logger.info("Select by {}", method.name());

                if (method == Method.BubbleSort) {
                    selectKst.bubbleSort(outNums);
                }

                if (method == Method.DivideSelect) {
                    selectKst.divideSelect(outNums, 0, length, k);
                }

                duration = System.currentTimeMillis() - startTime;
                logger.info("Select by {} result: {}, duration {}", method.name(), outNums[k], duration);
            }

            logger.info("Leave");
            logger.info("");
            logger.info("");
        }
    }

    public void bubbleSort(double[] outNums) {
        for (int i=0; i < outNums.length; i++) {
            for (int j=outNums.length - 1; j > i; j--) {
                if (outNums[j] < outNums[j - 1]) {
                    double temp = outNums[j - 1];
                    outNums[j - 1] = outNums[j];
                    outNums[j] = temp;
                }
            }
        }
    }

    public void divideSelect(double[] outNums, int start, int end, int k) {
        int length = end - start;

        if (length < 30) {
            double[] tmpNums = new double[length];
            System.arraycopy(outNums, start, tmpNums, 0, length);

            bubbleSort(tmpNums);

            System.arraycopy(tmpNums, 0, outNums, start, length);

            return;
        }

        int subLen = 9;
        double[] tmpNums = new double[subLen];
        System.arraycopy(outNums, start, tmpNums, 0, subLen);
        bubbleSort(tmpNums);
        System.arraycopy(tmpNums, 0, outNums, start, subLen);
        double mid = tmpNums[subLen / 2];

        int i = start + subLen / 2;
        int j = end - 1;

        while (i < j) {
            while (i < j && outNums[j] >= mid) {
                j--;
            }

            if (i < j) {
                outNums[i++] = outNums[j];
            }

            while (i < j && outNums[i] <= mid) {
                i++;
            }

            if (i < j) {
                outNums[j--] = outNums[i];
            }
        }

        outNums[i] = mid;
//        logger.info("divideSelect mid {} start {} i {} end {}", mid, start, i, end);

        if (i < k) {
            divideSelect(outNums, i+1, end, k);
        } else if (i > k) {
            divideSelect(outNums, start, i, k);
        }
    }
}
