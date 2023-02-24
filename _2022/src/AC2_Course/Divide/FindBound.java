package AC2_Course.Divide;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindBound {
    public int[] findBound(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return findBound(nums, 0, nums.length - 1, target);
    }

    //find target left and right index[
    //if target doesn't exist , return [-1, -1]
    int[] findBound(int[] nums, int l, int r, int target) {
        //find left bound: set mid towards left side, push to the right
        int l1 = l;
        int r1 = r;
        while (l1 < r1) {
            int mid = l1 + (r1 - l1) / 2;
            if (nums[mid] < target) {
                l1 = mid + 1;
            } else {
                r1 = mid;
            }
        }
        //not exist
        if (nums[l1] != target) {
            return new int[]{-1, -1};
        }

        //find right bound: set mid towards right side, push to the left
        int l2 = l;
        int r2 = r;
        while (l2 < r2) {
            int mid = l2 + (r2 - l2 + 1) / 2;
            if (nums[mid] > target) {
                r2 = mid - 1;
            } else {
                l2 = mid;
            }
        }

        return new int[]{l1, l2};
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(int[] nums, int target, int[] result) {

        int[] bound = findBound(nums, target);
        Assertions.assertArrayEquals(result, bound);
    }

    static Stream<Arguments> source() {
        int[] nums = {1, 2, 2, 3, 3, 4};
        return Stream.of(
                arguments(nums, 3, new int[]{3, 4}),
                arguments(nums, 4, new int[]{5, 5}),
                arguments(nums, 5, new int[]{-1, -1}),
                arguments(new int[]{}, 5, new int[]{-1, -1})
        );
    }
}
