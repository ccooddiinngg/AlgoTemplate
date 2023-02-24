package AC2_Course.Divide;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CubeRoot {
    public double cubeRoot(double n) {
        double l;
        double r;
        if (n > 0) {
            l = 0;
            r = Math.max(1, n);
        } else {
            l = Math.min(-1, n);
            r = 0;
        }

        double delta = 1e-8;
        while (l < r - delta) {
            double mid = l + (r - l) / 2;
            if (mid * mid * mid > n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.0, 100.0, 8.0, -1, -8.0, -0.001, -0.34, 0})
    void test(double n) {
        Assertions.assertEquals(Math.cbrt(n), cubeRoot(n), 1e-8);
    }
}
