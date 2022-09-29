package tag.DynamicProgramming;

import org.junit.jupiter.api.Test;

class BurstBalloonsTest {
    BurstBalloons burstBalloons = new BurstBalloons();

    @Test
    void test() {
        int[] nums = {3, 1, 5, 8};
        int maxCoins = burstBalloons.maxCoins(nums);
        System.out.println(maxCoins);
    }

}