package tag.DynamicProgramming;

import org.junit.jupiter.api.Test;

class CoinChangeTest {
    CoinChange coinChange = new CoinChange();

    @Test
    void test() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int res = coinChange.coinChange(coins, amount);
        System.out.println(res);
    }

}