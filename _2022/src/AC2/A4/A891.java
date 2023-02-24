package AC2.A4;

import java.util.Scanner;


//假设n堆石子，石子数目分别是a1,a2,…,an，如果a1⊕a2⊕…⊕an≠0，先手必胜；否则先手必败。
public class A891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= nums[i];
        }
        if (res == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
