package Leetcode.Coding_Interview_6.C16;

public class S01 {
    public int[] swapNumbers(int[] numbers) {
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[1] ^ numbers[0];
        numbers[1] = numbers[1] ^ numbers[0];
        return numbers;
    }
}
