package ZuoChengyun.Basic.Day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinaryOperator {

    //异或也叫半加运算，其运算法则相当于不带进位的二进制加法 （同为0，异为1）
    // 0 ^ N = N
    // N ^ N = 0
    int XOR(int a, int b) {
        return a ^ b;
    }

    //find the only odd appearance num
    int findOneOdd(int[] array) {
        int ans = 0;
        for (int num : array) {
            ans ^= num;
        }
        return ans;
    }

    //catch right position 1
    //0010 0100 1010 0000 -> 0000 0000 0010 0000
    int keepRightOne(int num) {
        //& 与
        //~ 取反
        //0010 0100 1010 0000 => 1101 1011 0101 1111 => 1101 1011 0110 0000 => 0000 0000 0010 0000
        return num & (~num + 1);
    }

    //find the two odd appearance nums
    int[] findTwoOdd(int[] array) {
        //if answer is {a, b}, find xor = a ^ b
        int xor = findOneOdd(array);
        //transform xor to a num which only has one 1 in binary form. because a != b, it should exist.
        int transform = keepRightOne(xor);

        int ans = 0;
        for (int num : array) {
            //XOR nums has 1 in the same position, it shouldn't include other odd num, but include even appearance nums.
            if ((num & transform) != 0) {
                ans ^= num;
            }
        }
        int[] result = new int[2];
        result[0] = ans;
        result[1] = xor ^ ans;
        return result;
    }

    //count how many 1
    int count(int num) {
        int count = 0;
        while (num != 0) {
            int keepRightOne = keepRightOne(num);
            count++;
            num = num ^ keepRightOne;
        }
        return count;
    }

    @Test
    void test1() {
        System.out.println(XOR(6, 7));
    }

    @Test
    void test2() {
        int a = 1;
        int b = 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }

    @Test
    void test3() {
        int[] array = {1, 2, 3, 4, 1, 2, 2, 3, 3, 3, 4};
        int num = findOneOdd(array);
        System.out.println(num);
    }

    @Test
    void test4() {
        int a = 6;
        int transform = keepRightOne(a);
        System.out.println(transform);
    }

    @Test
    void test5() {
        int[] array = {1, 2, 3, 4, 1, 2, 2, 3, 3, 3, 4, 4};
        int[] result = findTwoOdd(array);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void test6() {
        int num = 3;
        int count = count(num);
        System.out.println(count);
    }
}
