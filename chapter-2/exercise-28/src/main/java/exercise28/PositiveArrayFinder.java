package exercise28;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PositiveArrayFinder {
    private static final Logger logger = LoggerFactory.getLogger(PositiveArrayFinder.class);

    /**
     * b. a[j] - a[i]的最大值，其中j >= i
     */
    public double findMaxOfAjMinusAi(double[] inArray) {
        logger.debug("inArray: {}", inArray);

        double leftHalfMin = inArray[0];
        double rightHalfMax = inArray[0];
        double rightHalfMaxIdx = 0;
        double candidate;

        for (int i=1; i < inArray.length; i++) {
            if (inArray[i] >= rightHalfMax) {
                rightHalfMax = inArray[i];
                rightHalfMaxIdx = i;
            }
        }

        candidate = rightHalfMax - leftHalfMin;

        for (int i=1; i < inArray.length; i++) {
            if (i > rightHalfMaxIdx) {
                rightHalfMax = inArray[i];

                for (int j=i+1; j < inArray.length; j++) {
                    if (inArray[j] >= rightHalfMax) {
                        rightHalfMax = inArray[j];
                        rightHalfMaxIdx = j;
                    }
                }
            }

            if (inArray[i] < leftHalfMin) {
                leftHalfMin = inArray[i];

                if ((rightHalfMax - leftHalfMin) > candidate) {
                    candidate = rightHalfMax - leftHalfMin;
                }
            }
        }

        logger.debug("result: {}", candidate);

        return candidate;
    }

    /**
     * b. a[j] / a[i]的最大值，其中j >= i
     */
    public double findMaxOfAjDivideAi(double[] inArray) {
        logger.debug("inArray: {}", inArray);

        double leftHalfMin = inArray[0];
        double rightHalfMax = inArray[0];
        double rightHalfMaxIdx = 0;
        double candidate;

        for (int i=1; i < inArray.length; i++) {
            if (inArray[i] >= rightHalfMax) {
                rightHalfMax = inArray[i];
                rightHalfMaxIdx = i;
            }
        }

        candidate = rightHalfMax / leftHalfMin;

        for (int i=1; i < inArray.length; i++) {
            if (i > rightHalfMaxIdx) {
                rightHalfMax = inArray[i];

                for (int j=i+1; j < inArray.length; j++) {
                    if (inArray[j] >= rightHalfMax) {
                        rightHalfMax = inArray[j];
                        rightHalfMaxIdx = j;
                    }
                }
            }

            if (inArray[i] < leftHalfMin) {
                leftHalfMin = inArray[i];

                if ((rightHalfMax / leftHalfMin) > candidate) {
                    candidate = rightHalfMax / leftHalfMin;
                }
            }
        }

        logger.debug("result: {}", candidate);

        return candidate;
    }
}
