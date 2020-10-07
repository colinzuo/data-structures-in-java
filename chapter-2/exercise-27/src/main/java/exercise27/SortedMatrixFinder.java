package exercise27;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Objects;

public class SortedMatrixFinder {
    private static final Logger logger = LoggerFactory.getLogger(SortedMatrixFinder.class);

    public Result find (double target, double[][] nums) {
        logger.debug("Enter with target: {}, nums: {}", target, Arrays.deepToString(nums));

        Result found = find(target, nums, 0, nums.length, 0, nums[0].length);

        logger.debug("found {}", found);
        logger.debug("");

        return found;
    }

    public Result find(double target, double[][] nums,
                       int dim1Start, int dim1End, int dim2Start, int dim2End) {
        logger.debug("Enter with dim1Start: {}, dim1End: {}, dim2Start: {}, dim2End: {}",
                dim1Start, dim1End, dim2Start, dim2End);

        int dim1Len = dim1End - dim1Start;
        int dim2Len = dim2End - dim2Start;
        int dimLen;

        if (dim1Len == 1) {
            int start = dim2Start;
            int end = dim2End;
            int mid;

            while (start < end) {
                mid = (end + start) / 2;

                if (Double.compare(nums[dim1Start][mid], target) < 0) {
                    start = mid + 1;
                } else if (Double.compare(nums[dim1Start][mid], target) > 0) {
                    end = mid;
                } else {
                    return new Result(true, dim1Start, mid);
                }
            }

            return Result.notFound;
        } else if (dim2Len == 1) {
            int start = dim1Start;
            int end = dim1End;
            int mid;

            while (start < end) {
                mid = (end + start) / 2;

                if (Double.compare(nums[mid][dim2Start], target) < 0) {
                    start = mid + 1;
                } else if (Double.compare(nums[mid][dim2Start], target) > 0) {
                    end = mid;
                } else {
                    return new Result(true, mid, dim2Start);
                }
            }

            return Result.notFound;
        }

        if (dim1Len <= dim2Len) {
            dimLen = dim1Len;
        } else {
            dimLen = dim2Len;
        }

        logger.debug("dimLen: {}", dimLen);

        int start = 0;
        int end = dimLen;
        int mid;

        while (start < end) {
            mid = (end + start) / 2;

            if (Double.compare(nums[dim1Start + mid][dim2Start + mid], target) < 0) {
                start = mid + 1;
            } else if (Double.compare(nums[dim1Start + mid][dim2Start + mid], target) > 0) {
                end = mid;
            } else {
                return new Result(true, dim1Start + mid, dim2Start + mid);
            }
        }

        if (Double.compare(nums[dim1Start + start][dim2Start + start], target) > 0) {
            if (start == 0) {
                return Result.notFound;
            }

            start -= 1;
        }

        Result result = find(target, nums,
                dim1Start, dim1Start + start + 1, dim2Start + start + 1, dim2End);

        if (result.isFound()) {
            return result;
        }

        result = find(target, nums,
                dim1Start + start + 1, dim1End, dim2Start, dim2Start + start + 1);

        return result;
    }

    public static class Result {
        boolean found;
        int dim1;
        int dim2;

        public static final Result notFound = new Result(false, 0, 0);

        public Result(boolean found, int dim1, int dim2) {
            this.found = found;
            this.dim1 = dim1;
            this.dim2 = dim2;
        }

        public boolean isFound() {
            return found;
        }

        public int getDim1() {
            return dim1;
        }

        public int getDim2() {
            return dim2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return found == result.found &&
                    dim1 == result.dim1 &&
                    dim2 == result.dim2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(found, dim1, dim2);
        }

        @Override
        public String toString() {
            return "Result{" +
                    "found=" + found +
                    ", dim1=" + dim1 +
                    ", dim2=" + dim2 +
                    '}';
        }
    }
}
