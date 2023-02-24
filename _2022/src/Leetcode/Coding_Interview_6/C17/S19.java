package Leetcode.Coding_Interview_6.C17;


//1. 找到两个数的XOR: one ^ two
//2. 找到两个数的最低不同位
//3. 利用这个不同位把数组分为两部分: 此位置相同的，此位置不同的
//4. 把一组数与 ^ XOR 就得到另外一个数
public class S19 {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int diff = xor & -xor;
        int one = xor;
        for (int num : nums) {
            if ((diff & num) == 0) {
                one ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((diff & i) == 0) {
                one ^= i;
            }
        }
        return new int[]{one, xor ^ one};
    }
}
